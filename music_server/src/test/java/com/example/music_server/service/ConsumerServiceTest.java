package com.example.music_server.service;

import com.example.music_server.common.WarningMessage;
import com.example.music_server.domain.Comment;
import com.example.music_server.domain.Consumer;
import com.example.music_server.service.impl.CommentServiceImpl;
import com.example.music_server.service.impl.ConsumerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ConsumerServiceTest {
    @Autowired
    private ConsumerServiceImpl consumerService;
    static Consumer consumer = new Consumer();
    static void  Init(){
        String username = "测试用户1";
        String password = "123456".trim();
        String sex = "0".trim();
        String email = "10000@gmail.com";
        String birth = "2023-05-10 08:00:00";
        String introduction = "ceshi";
        String location = "湖北";
        String avator = "/img/avatorImages/user.jpg";

        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setEmail("100111@gmail.com");
        consumer.setPhoneNum("12312312");
        consumer.setIntroduction(introduction);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.setBirth(myBirth);
        consumer.setLocation(location);
        consumer.setAvator(avator);
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());
    }

    @Test
    void addUser() {
        Init();
       boolean result_add = consumerService.addUser(consumer);
       assertTrue(result_add);
    }

    @Test
    void updateUserMsg() {
        Init();
        consumer.setId(31);
        boolean res = consumerService.updateUserMsg(consumer);
        assertTrue(res);
        consumer.setId(null);
    }

    @Test
    void updateUserAvator() {
        Init();
        consumer.setId(31);
        boolean res = consumerService.updateUserAvator(consumer);
        assertTrue(res);
        consumer.setId(null);
    }

    @Test
    void updatePassword() {
        Init();
        consumer.setId(31);
        boolean res = consumerService.updatePassword(consumer);
        assertTrue(res);
        consumer.setId(null);
    }

    @Test
    void existUser() {
        Init();
        boolean res = consumerService.existUser("测试用户1");
        if(res){
            deleteUser();
            assertFalse(consumerService.existUser("测试用户1"));
            addUser();
            assertTrue(consumerService.existUser("测试用户1"));
        }
        else{
            addUser();
            assertTrue(consumerService.existUser("测试用户1"));
        }
    }

    @Test
    void veritypasswd() {
        Init();
        boolean res = consumerService.existUser("测试用户1");
        if(!res){
            addUser();
            assertTrue(consumerService.existUser("测试用户1"));
        }
        assertTrue(consumerService.veritypasswd("测试用户1","123456"));
    }

    @Test
    void deleteUser() {
        Init();
        boolean res = consumerService.existUser("测试用户1");
        if(!res){
            consumerService.addUser(consumer);
        }
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