package com.cn.aspect;


import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志输出
 */
@Aspect
@Order(1)//i的值越小，优先级越高
@Component
public class LoggerAspect {
    private Logger logger= Logger.getLogger(getClass());

    ThreadLocal<Long> startTime=new ThreadLocal<Long>();
    @Pointcut("execution(public * com.cn.controller..*.*(..))")
    public void controllerPackage(){}
    @Pointcut("execution(public * com.cn.handler..*.*(..))")
    public void handlerPackage(){}
    @Pointcut("controllerPackage()|| handlerPackage()")
    public void all(){}
    @Before("controllerPackage()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        startTime.set(System.currentTimeMillis());
        //记录请求内容
        logger.info("################请求内容#######################");
        logger.info("URL:"+request.getRequestURI().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("CLASS_METHOD:"+joinPoint.getSignature());
        logger.info("CLAA_ARGS:" + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "ret",pointcut = "all()")
    public void doAfterReturning(Object ret){
        logger.info("################响应内容#######################");
        logger.info("RESPONSE:"+ JSONObject.toJSONString(ret));
        logger.info("耗时："+(System.currentTimeMillis()-startTime.get()));
    }
}
