package com.cn.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2016/11/23.
 * 读取自定义properties文件并注入
 */
@ConfigurationProperties(prefix = "myself",locations = "classpath:myself.properties")
public class MySelfUser {
    private String username;
    private String userPwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
