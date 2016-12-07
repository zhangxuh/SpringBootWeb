package com.cn.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.PasswordAuthentication;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/25.
 */
@Controller
public class UserInfoController {
    public final static Logger logger=Logger.getLogger(UserInfoController.class);
    @RequestMapping(value =  "doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,String username,String password,Map<String, Object> model){
        String shiroLoginFailure=(String) request.getAttribute("shiroLoginFailure");
        String msg=null;
        if(UnknownAccountException.class.getName().equals(shiroLoginFailure)){
            logger.error("UnknownAccountException -- > 账号不存在：");
            msg="账号不存在";
        }else if(IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)){
            logger.error("IncorrectCredentialsException -- > 密码不正确：");
            msg="密码不正确";
        }else if(LockedAccountException.class.getName().equals(shiroLoginFailure)){
            logger.error("LockedAccountException -- > 用户被锁定：");
            msg="用户被锁定";
        }else if(ExcessiveAttemptsException.class.getName().equals(shiroLoginFailure)){
            logger.error("ExcessiveAttemptsException -- > 认证次数过多：");
            msg="认证次数过多";
        }else if(AuthenticationException.class.getName().equals(shiroLoginFailure)){
            logger.error("错误");
            msg="错误";
        }
        if(msg==null){
            request.getSession().setAttribute("username", username);
            return "redirect:/index";
        }
        model.put("errorMsg",msg);
        return "redirect:/login";
    }
    @RequestMapping(value =  "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value =  "logout",method = RequestMethod.GET)
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
    }
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(HttpServletRequest request,Map<String, Object> model){
        model.put("username",request.getSession().getAttribute("username"));
        return "index";
    }
    @RequestMapping(value = "userList",method = RequestMethod.GET)
    public String userList(){
        return "index";
    }
}
