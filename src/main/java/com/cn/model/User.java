package com.cn.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/10.
 *基于JPA
 */
//@Entity
//@Table(name="")
public class User {
//    @Id
//    @GenericGenerator(name="idGenerator",strategy = "uuid")//这个是hibernate的注解/生成32位UUID
//    @GeneratedValue(generator = "idGenerator")
    private String userId;
//    @Column(name="user_name",length = 5)
    private String userName;
    private int age;
    private String email;
    public User(){}
    public User(String userName,int age,String email){
        this.userName=userName;
        this.age=age;
        this.email=email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
