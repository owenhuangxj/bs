package com.ss.bookstore.controller;

import com.ss.bookstore.entity.Book;
import com.ss.bookstore.entity.User;
import com.ss.bookstore.model.ResultMap;
import com.ss.bookstore.service.BookService;
import com.ss.bookstore.service.UserService;
import com.ss.bookstore.util.JsonData;
import com.ss.bookstore.contant.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private ResultMap resultMap;
    @Autowired
    private UserService userService;

    @GetMapping("loginAction")
    public JsonData loginAction(User user) {
        System.out.println("user : " + user);
        return new JsonData(null, Constant.LoginSuccess,true);
    }
    public JsonData addBookAction(Book book){
        return null;
    }
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return resultMap.success().message("成功注销！");
    }
    @PostMapping("adminLogin")
    public ResultMap adminLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
//        String role = userMapper.getRole(username);
        String role = userService.getRole(username);
        if ("user".equals(role)) {
            return resultMap.success().message("欢迎登陆");
        }
        if ("admin".equals(role)) {
            return resultMap.success().message("欢迎来到管理员页面");
        }
        return resultMap.fail().message("权限错误！");
    }
}
