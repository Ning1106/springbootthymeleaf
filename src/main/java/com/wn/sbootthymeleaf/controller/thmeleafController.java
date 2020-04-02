package com.wn.sbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class thmeleafController {

    @Autowired
    private ServletContext servletContext;


    @RequestMapping("/thmeleaf/test")
    public String test(ModelMap model, HttpSession httpSession){
        //1.数据存入请求域
        model.addAttribute("requestAtt","<p style='color:red'>请求域数据</p>");

        //2.数据存入会话域
        httpSession.setAttribute("sessionAtt","会话域数据");

        //3.数据存入应用域
        servletContext.setAttribute("servletAtt","应用域数据");

        //4.加入list
        model.addAttribute("list", Arrays.asList("123","abc","qwe",",./"));

        return "hello";
    }
}
