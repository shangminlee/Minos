package cm.xxx.minos.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Description: 用户
 * Author: lishangmin
 * Created: 2018-07-22 23:53
 */
@Builder
@AllArgsConstructor
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{};

    private String id;

    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日不能大于当前日期")
    private Date birthday;

    public User() {
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
