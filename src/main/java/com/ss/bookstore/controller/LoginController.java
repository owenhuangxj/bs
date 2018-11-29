package com.ss.bookstore.controller;

import com.ss.bookstore.entity.User;
import com.ss.bookstore.util.JsonData;
import com.ss.bookstore.contant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @ResponseBody
    @GetMapping("loginAction")
    public JsonData loginAction(User user) {
        System.out.println("user : " + user);
        return new JsonData(null, Constant.LoginSuccess,true);
    }
}
