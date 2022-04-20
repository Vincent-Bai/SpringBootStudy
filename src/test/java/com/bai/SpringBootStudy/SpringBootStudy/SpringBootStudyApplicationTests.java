package com.bai.SpringBootStudy.SpringBootStudy;

import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.bai.SpringBootStudy.SpringBootStudy.utils.RabbitSender;
import com.bai.SpringBootStudy.SpringBootStudy.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootStudyApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RabbitSender rabbitSender;


    @Test
    void insertUserTest() {
        User user = new User();
        user.setName("吴老二");
        user.setAge(33);
        user.setBir(new Date());
        //userService.insertUser(user);
    }

    @Test
    void getAllUser() {
        List<User> users = userService.getAllUser();
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }


    @Test
    public void redisTest() {
      /*  List<User> allUser = userService.list();
        ObjectMapper objectMapper = new ObjectMapper();

        allUser.forEach(user -> {
            try {
                //string存储
                String str = objectMapper.writeValueAsString(user);
                redisUtil.set(user.getName(), str, 60);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });*/
    }

    @Test
    void rabbitMQTest() {
        for (int i = 0; i < 20; i++) {
            rabbitSender.send("这是消息" + i + "这是一个测试的消息！来自【掘金，小阿杰】");
        }
    }

}
