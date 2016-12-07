package com.cn.config.shiro;

import com.cn.model.UserInfo;
import com.cn.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 身份校验核心类
 * Created by Administrator on 2016/11/25.
 */
@Component
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 返回权限信息
     * 权限控制，当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    /**
     * 身份验证
     1、检查提交的进行认证的令牌信息
     2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     3、对用户信息进行匹配验证。
     4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     5、验证失败则抛出AuthenticationException异常信息。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName= (String) token.getPrincipal();
        UserInfo userInfo=userInfoService.findUserByUserName(userName);
        if(userInfo==null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo,userInfo.getUserPwd(),getName());
        return authenticationInfo;
    }
}
