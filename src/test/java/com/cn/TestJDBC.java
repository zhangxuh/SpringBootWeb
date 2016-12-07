package com.cn;

import com.cn.dao.PageableTools;
import com.cn.dao.SortTools;
import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/10.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TestJDBC {
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private UserService userService;
////    @Test
//    public void addUser(){
//        User user=new User();
//        user.setUserName("张三");
//        user.setAge(18);
//        user.setEmail("123455");
//        userDao.save(user);
//    }
////    @Test
//    public void findOne(){
//        User user=userDao.findOne("40289035584d73f801584d7400300000");
//        System.out.println(user.getUserName());
//    }
////    @Test
//    public void findAll(){
//        List<User> users=userDao.findAll();
//        for(User user:users) {
//            System.out.println(user.getUserName());
//        }
//    }
//    @Test
//    public void findAllByPage(){
//        Page<User> users=userDao.findAll(PageableTools.basicPage(1,1));
//        for(User user:users) {
//            System.out.println(user.getUserName());
//        }
//    }
////    @Test
//    public void findAllByAgeDesc(){
//        List<User> users=userDao.findAll(SortTools.basicSort("asc","age"));
//        for(User user:users) {
//            System.out.println(user.getAge()+"----"+user.getUserName());
//        }
//    }
////    @Test
//    public void updateUser(){
//        User user=userDao.findOne("40289035584d73f801584d7400300000");
//        user.setAge(30);
//        userDao.save(user);
//    }
////    @Test
//    public void deleteUser(){
////        User user=userDao.findOne("40289035584d73f801584d7400300000");
////        user.setAge(30);
//        userDao.delete("40289035584d73f801584d7400300000");
//    }
////    @Test
//    public void testInsert(){
//        userService.insert();
//    }
////    @Test
//    public void findUserByName(){
//        User user1= userDao.findByUserName("王二");
//        System.out.println(user1.getAge());
//
//        List<User> users= userDao.findByAge(17);
//        for(User user:users){
//            System.out.println(user.getUserName());
//        }
//    }
////    @Test
//    public void testHQL(){
//        User user=userDao.findByUserNameHQL("王二");
//        System.out.println(user.getAge());
////        userDao.updateAgeByUserName("王二", new Random().nextInt(100));
//        userDao.updateAgeByUserName1("王二", new Random().nextInt(100));
//        user=userDao.findByUserNameHQL("王二");
//        System.out.println(user.getAge());
//    }
////    @Test
//    public void testDeleteHQL(){
//        userDao.deleteByUserName("赵六");
//    }
}
