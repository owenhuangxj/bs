package com.ss.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController  {
    @RequestMapping("/login")
    public String toLoginPage(){
        return "login";
    }
    @RequestMapping("/upload")
    public String toFileUploadPage(){
        return "upload";
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
