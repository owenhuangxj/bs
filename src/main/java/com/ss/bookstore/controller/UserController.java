package com.ss.bookstore.controller;

import com.ss.bookstore.model.ResultMap;
import com.ss.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private ResultMap resultMap;
    @GetMapping("/getUser")
    public String getUser() {
        return userService.getUser(001);
    }
    @GetMapping("/getMessage")
    public ResultMap getMessage() {
        return resultMap.success().message("您拥有用户权限，可以获得该接口的信息！");
    }
}