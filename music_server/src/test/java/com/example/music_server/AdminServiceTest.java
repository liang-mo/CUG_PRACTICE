package com.example.music_server;

import com.example.music_server.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminServiceImpl adminService;
    //判断验证密码
    @Test
    void veritypasswd() {
        boolean result_true = adminService.veritypasswd("admin","123");
        boolean result_false = adminService.veritypasswd("admin","1234");
        assertTrue(result_true);
        assertFalse(result_false);
    }
}