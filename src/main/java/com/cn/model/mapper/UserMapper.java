package com.cn.model.mapper;

import com.cn.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2016/11/29.
 */
@Mapper
public interface UserMapper {
    User findByUserName(String name);
}
