package com.cn.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/11/11.
 */
public class LoginInterceptor implements HandlerInterceptor{
    private Logger logger= Logger.getLogger(getClass());
    //在请求处理之前进行调用
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>在请求处理之前进行调用");
        return true;//只有返回true才会继续向下执行，返回false取消当前请求
    }
    //请求处理之后进行调用，但是在视图被渲染之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>请求处理之后进行调用，但是在视图被渲染之前");
    }
    //在整个请求结束之后被调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>在整个请求结束之后被调用");
    }
}
