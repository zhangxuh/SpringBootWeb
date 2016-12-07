package com.cn.dao;

import com.cn.model.User;

import java.util.List;

/**
 都需要以findBy开头，且方法中的字段名必须与实体类中的属性名一致，并遵循驼峰式代码编写风格

 And：等价于SQL中的and关键字，比如：findByUserNameAndPassword(String username, String pwd)；

 Or：等价于SQL中的or关键字，比如：findByUserNameOrEmail(String username, String email)；

 Between：等价于between关键字（介于两者之间），比如：findByAgeBetween(int max, int min)（获取age在max和min之间的数据）；

 LessThan：等价于<，比如：findByAgeLessThan(int val)（获取age小于val的数据）；

 GreaterThan:等价于>，比如：findByAgeGreaterThan(int val)（获取age大于val的数据）；

 IsNull：等价于is null，比如：findByEmailIsNull()（获取email为空的数据）；

 IsNotNull：等价于is not null，比如：findByEmailIsNotNull()（获取email不为空的数据）；

 NotNull：等价于IsNotNull；

 Like：等价于like，比如：findByUserNameLike(String val)（获取userName中包含val的数据，在传入val的时候可以在首尾处加上%）；

 NotLike：等价于not like，比如：findByUserNameNotLike(String val)（获取userName中不包含val的数据，在传入val的时候也可以在首尾处加上%）；

 Not：等价于!=，比如：findByUserNameNot(String val)（获取userName不等于val的数据）；

 In：等价于in，比如：findByUserNameIn(Collection<String> vals)或findByUserNameIn(String... vals)（获取userName在集合vals中的数据，参数类型可以是集合，也可以是数组，或不指定长度的数组）；

 NotIn：等价于not in，，比如：findByUserNameNotIn(Collection<String> vals)或findByUserNameNotIn(String... vals)（获取userName不在集合vals中的数据，参数类型可以是集合，也可以是数组，或不指定长度的数组）；

 OrderBy：等价于order by，比如：findByUserNameOrderByIdAsc(String userName)（Asc也可以换成Desc来更换排序方式）；.
 */
//JpaRespsitory接口有两个泛型，第一个：指具体的实体对象User，第二个：String
public interface UserDao /*extends JpaRepository<User,String>*/{
    //通过字段获取数据
    User findByUserName(String username);
    List<User> findByAge(int age);
//    //以HQL方式获取数据
//    @Query("FROM User u where u.userName=?1")
//    User findByUserNameHQL(String username);
//
//    @Query("UPDATE User u set u.age=?2 where u.userName=?1")
//    @Modifying
//    @Transactional
//
//    void updateAgeByUserName1(String userName,int age);
//    @Query("UPDATE User u set u.age=:age where u.userName=:userName")
//    @Modifying
//    @Transactional
//    void updateAgeByUserName(@Param("userName")String userName,@Param("age")int age);
//
//
//    @Query("DELETE FROM User u WHERE u.userName=?1")
//    @Modifying
//    @Transactional
//    void deleteByUserName(String userName);

}
