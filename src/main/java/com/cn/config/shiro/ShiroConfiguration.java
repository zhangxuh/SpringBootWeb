package com.cn.config.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Apache Shiro 核心通过 Filter 来实现
 * 需要定义一系列关于URL的规则和访问权限
 * Created by Administrator on 2016/11/23.
 */
//@Configuration
public class ShiroConfiguration {
    public final static Logger logger=Logger.getLogger(ShiroConfiguration.class);
    @Autowired
    private MyShiroRealm myShiroRealm;
    /**
     *
     * @param securityManager
     * @return
     */
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shirFilter()>>>>>>>>>>>>>>");
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 添加自定义filter到shiroFilter中
        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("authcFilter", getAuthcFilter());
        shiroFilterFactoryBean.setFilters(filters);
        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    /**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     * @param shiroFilterFactoryBean
     */
    private void  loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean){
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->
        /*********************************
         anon:所有url都都可以匿名访问;
         authc: 需要认证才能进行访问;
         user:配置记住我或认证通过可以访问；
         *********************************/
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/register", "anon");
        filterChainDefinitionMap.put("/doLogin", "authcFilter");
        logger.info("##################从数据库读取权限规则，加载到shiroFilter中##################");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }
    @Bean(name="securityManager")
    public SecurityManager securityManager(){
        System.out.println("ShiroConfiguration.securityManager : 实例化");
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);//注入realm
        EhCacheManager ehCacheManager=getEhCacheManager();
        myShiroRealm.setCacheManager(ehCacheManager);
        securityManager.setCacheManager(ehCacheManager);//注入缓存
        return securityManager;
    }
    @Bean
    public EhCacheManager getEhCacheManager(){
        System.out.println("ShiroConfiguration.getEhCacheManager()");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return cacheManager;
    }
    public AuthcFilter getAuthcFilter(){
        AuthcFilter authcFilter=new AuthcFilter();
        authcFilter.setName("authcFilter");
        /*
         * 这里一定要写 否则filter会有两个url 一个是继承shiroFilterFactoryBean的，一个是filterChainDefinitionMap设置的
         * 导致两个url都会经过该filter
         */
        authcFilter.setLoginUrl("/doLogin");
        authcFilter.setEnabled(true);
        return authcFilter;
    }
}