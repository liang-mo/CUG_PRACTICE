package com.example.music_server;

import com.example.music_server.common.WarningMessage;
import com.example.music_server.domain.Consumer;
import com.example.music_server.service.impl.CommentServiceImpl;
import com.example.music_server.service.impl.ConsumerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsumerServiceTest {
    @Autowired
    private ConsumerServiceImpl consumerService;
    Consumer consumer = new Consumer();
    void Init(){
        String username = "测试用户";
        String password = "123456".trim();
        String sex = "0".trim();
        String phone_num = "10000".trim();
        String email = "10000@gmail.com".trim();
        String birth = "2023-05-10 08:00:00".trim();
        String introduction = "ceshi".trim();
        String location = "湖北".trim();
        String avator = "/img/avatorImages/user.jpg";

        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        if ("".equals(phone_num)) {
            consumer.setPhoneNum(null);
        } else {
            consumer.setPhoneNum(phone_num);
        }

        if ("".equals(email)) {
            consumer.setEmail(null);
        } else {
            consumer.setEmail(email);
        }
        consumer.setBirth(myBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setAvator(avator);
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());
    }

    @Test
    void addUser() {
        Init();
       // boolean result_add = consumerService.addUser(consumer);
    }

    @Test
    void updateUserMsg() {
    }

    @Test
    void updateUserAvator() {
    }

    @Test
    void updatePassword() {
    }

    @Test
    void existUser() {
    }

    @Test
    void veritypasswd() {
        assertTrue(consumerService.veritypasswd("cjx","123"));
        assertFalse(consumerService.veritypasswd("cjx","123123"));
        assertFalse(consumerService.veritypasswd("13244","123123"));

    }

    @Test
    void deleteUser() {
    }

    @Test
    void allUser() {
        System.out.println(consumerService.allUser());
    }

    @Test
    void userOfId() {
    }

    @Test
    void loginStatus() {
        System.out.println(consumerService.loginStatus(consumer.getUsername()));
    }
}