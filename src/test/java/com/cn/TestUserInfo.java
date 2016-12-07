package com.cn;

import com.cn.model.User;
import com.cn.model.UserInfo;
import com.cn.model.mapper.UserInfoMapper;
import com.cn.model.mapper.UserMapper;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by Administrator on 2016/11/23.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TestUserInfo {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMapper userMapper;

//    @Test
    public void findUserInfoByName(){
        UserInfo userInfo=userInfoMapper.findByUserName("123");
        System.out.println(userInfo);
    }
//    @Test
    public void addUser(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setUserName("张三");
        System.out.println(userInfoMapper.addUserInfo(userInfo));
    }
    @Test
    public void addUser1(){
       User user=userMapper.findByUserName("王二");
        System.out.println(user);
    }

}
