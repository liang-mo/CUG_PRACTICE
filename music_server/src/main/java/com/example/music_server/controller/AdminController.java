package com.example.music_server.controller;

import com.example.music_server.common.ErrorMessage;
import com.example.music_server.common.SuccessMessage;
import com.example.music_server.service.impl.AdminServiceImpl;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    // 判断是否登录成功接口1234
    @ResponseBody
    @PostMapping ("/admin/login/status")
        public Object loginStatus(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        boolean res = adminService.veritypasswd(name, password);
        if (res) {
            session.setAttribute("name", name);
            return new SuccessMessage<Null>("登录成功").getMessage();
        } else {
            return new ErrorMessage("用户名或密码错误").getMessage();
        }
    }
}
