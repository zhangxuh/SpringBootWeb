package com.cn.controller;

import com.cn.model.MySelfUser;
import com.cn.util.FileUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/9.
 */
//@Controller
public class HelloWordController {
    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    private MySelfUser mySelfUser;

    @RequestMapping("index")
    public String index(){
        System.out.println("****111111222");
        return "Hello "+mySelfUser.getUsername()+"!>>>>>"+url;
    }
    @RequestMapping("welcome")
    public String welcome(String name){
        return "Welcome "+name;
    }



    @PostMapping("post")
    public String postJson(HttpServletRequest request){
        return "get Name:"+request.getParameter("name");
    }

    @RequestMapping("exception")
    public String exception() throws Exception{
        throw new Exception("msg");
    }
}
