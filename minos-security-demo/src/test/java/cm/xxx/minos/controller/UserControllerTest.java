package cm.xxx.minos.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Description: 测试类
 * Author: lishangmin
 * Created: 2018-07-22 23:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/user")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .param("username","admin")
                                .param("age","10")
                                .param("ageTo","20")
                                .param("xxx","yyy")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());

    }

    @Test
    public void whenGetInfoSuccess() throws Exception{
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/user/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());
    }

    @Test
    public void whenGetInfoFail() throws Exception{
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/user/a")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());
    }

    @Test
    public void whenCreateSuccess() throws Exception{
        Date time = new Date();
        String content = "{\"name\":\"tom\",\"password\":null,\"birthday\":"+time.getTime()+"}";
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/user")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(content)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());
    }


    @Test
    public void whenUpdateSuccess() throws Exception{
        Date time = new Date(
                LocalDateTime
                        .now()
                        .plusYears(1)
                        .atZone(ZoneId.systemDefault())
                        .toInstant().toEpochMilli()
        );
        String content = "{\"name\":\"tom\",\"password\":null,\"birthday\":"+time.getTime()+"}";
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .put("/user/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(content)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());
    }

    @Test
    public void whenDeleteSuccess() throws Exception{
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .delete("/user/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info("结果：{}",result.getResponse().getContentAsString());
    }

}