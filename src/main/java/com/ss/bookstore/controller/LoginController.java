package com.ss.bookstore.controller;

import com.ss.bookstore.entity.Book;
import com.ss.bookstore.entity.User;
import com.ss.bookstore.service.BookService;
import com.ss.bookstore.util.JsonData;
import com.ss.bookstore.contant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    @Autowired
    private BookService bs;
    @ResponseBody
    @GetMapping("loginAction")
    public JsonData loginAction(User user) {
        System.out.println("user : " + user);
        return new JsonData(null, Constant.LoginSuccess,true);
    }
    @GetMapping("/login")
    public String toLoginPage(){
        return "login";
    }

    public JsonData addBookAction(Book book){
        return null;
    }

    //测试thymeleaf获取request，session，application的Controller代码
//    @GetMapping("/login")
//    public ModelAndView login(ModelAndView mv, HttpServletRequest request, HttpSession session){
//        mv.addObject("mv","vm");
//        mv.setViewName("login");
//        request.setAttribute("qq","request");
//        session.setAttribute("ss","session");
//        request.getServletContext().setAttribute("pp","application");
//        return mv;
//    }
}
