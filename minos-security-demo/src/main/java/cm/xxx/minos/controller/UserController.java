package cm.xxx.minos.controller;

import cm.xxx.minos.dto.User;
import cm.xxx.minos.dto.UserQueryCondition;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 用户控制层
 * Author: lishangmin
 * Created: 2018-07-22 23:28
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @PostMapping
    @JsonView(User.UserDetailView.class)
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(
                    error -> log.info(error.getDefaultMessage())
            );
        }
        user.setId("1");
        log.info("参数:{}", JSON.toJSONString(user));
        return user;
    }


    @DeleteMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public boolean delete(@PathVariable String id){
        return false;
    }

    @PutMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User update(@PathVariable String id, @Valid @RequestBody User user, BindingResult errors){
        log.info("id:{}",id);
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(
                    error -> {
                        FieldError fieldError = (FieldError) error;
                        log.info("{}:{}",fieldError.getField(),fieldError.getDefaultMessage());
                    }
            );
        }
        user.setId("1");
        log.info("参数:{}", JSON.toJSONString(user));
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1,size = 10) Pageable pageable){
        log.info(condition.toString());
        log.info(pageable.toString());

        User user = User.builder().name("admin").password("456").id("1").build();
        return Arrays.asList(user,user,user);
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        return User.builder().name("tom").password("1234").id("1").build();
    }
}
