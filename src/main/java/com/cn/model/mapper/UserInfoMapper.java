package com.cn.model.mapper;

import com.cn.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/11/23.
 */
@Mapper
public interface UserInfoMapper {
//    @Select("SELECT * FROM USERINFO WHERE USERNAME=#{userName}")
    UserInfo findByUserName(String userName);

//    @Insert("INSERT INTO USERINFO(USERNAME)VALUES(#{userName})")
    int addUserInfo(UserInfo userInfo);
}
