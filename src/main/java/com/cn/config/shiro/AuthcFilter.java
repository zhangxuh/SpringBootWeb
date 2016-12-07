package com.cn.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/30.实现单个浏览器不退出多次登陆 用户不切换的问题
 */
public class AuthcFilter extends FormAuthenticationFilter {
    /**
     *校验成功，调用成功页面，不成功，调用登陆页面
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        boolean access=false;
        String username =request.getParameter("username");
//        String password =request.getParameter("password");
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//            access=true;
//        }catch (UnknownAccountException e){
//            request.setAttribute("shiroLoginFailure",UnknownAccountException.class.getName());
//        }catch (IncorrectCredentialsException e){
//            request.setAttribute("shiroLoginFailure",IncorrectCredentialsException.class.getName());
//        }catch ( LockedAccountException e ) { //用户被锁定，例如管理员把某个用户禁用...
//            request.setAttribute("shiroLoginFailure",LockedAccountException.class.getName());
//        } catch ( ExcessiveAttemptsException e ) {//尝试认证次数多余系统指定次数 ...
//            request.setAttribute("shiroLoginFailure",ExcessiveAttemptsException.class.getName());
//        }catch (AuthenticationException e){
//            request.setAttribute("shiroLoginFailure",AuthenticationException.class);
//        }
//        return access;
        AuthenticationToken token = this.createToken(request, response);
        if(token == null) {
            String e1 = "createToken method implementation returned null. A valid non-null AuthenticationToken must be created in order to execute a login attempt.";
            throw new IllegalStateException(e1);
        } else {
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
                httpServletRequest.getSession().setAttribute("username", username);
                return this.onLoginSuccess(token, subject, request, response);
            } catch (AuthenticationException var5) {
//                subject.logout();
                return this.onLoginFailure(token, var5, request, response);
            }
        }
    }

    /**
     * 设置每次登陆都要通过校验，解决浏览器用户不退出切换用户登陆的问题
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }
}
