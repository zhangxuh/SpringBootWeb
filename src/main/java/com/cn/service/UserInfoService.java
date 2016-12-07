package com.cn.service;

import com.cn.model.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/25.
 */
@Service
public class UserInfoService {
    public UserInfo findUserByUserName(String name){
        UserInfo userInfo=null;
        if("zhangsan".equals(name)){
            userInfo=new UserInfo();
            userInfo.setUserName(name);
            userInfo.setUserPwd("123");
        }else if("lisi".equals(name)){
            userInfo=new UserInfo();
            userInfo.setUserName(name);
            userInfo.setUserPwd("12345");
        }
        return userInfo;
    }
}
