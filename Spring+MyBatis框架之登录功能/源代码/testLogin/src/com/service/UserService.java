package com.service;

import com.dao.UserDao;
import com.po.UserInformation;
import com.controller.UserController;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Service层
@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    /*声明Service层的方法Login，类型为布尔型，返回一个布尔值，用于判断查询结果*/
    public boolean Login() {
        /*定义一个布尔型变量，用于存放查询结果的布尔值，并做方法的返回值使用*/
        boolean result;
        Map<String,Object> map = new HashMap<>();   //创建一个HashMap的对象map
        /*添加数据，对SQL语句中的对应参数进行传值，account和password都是SQL语句中的参数名*/
        map.put("account", UserController.input_account);
        map.put("password",UserController.input_password);
        List<UserInformation> list = userDao.selectOneUser(map);
        UserInformation userResult = null;  //用于接收list集合里面的对象
        for (UserInformation userInformation:list) {    //遍历输出list集合中的对象
            userResult = userInformation;
        }
        /*判断接收对象是否为空，因为list集合里没有对象，
        则userInformation对象会返回一个空值，否者返回获取到的值*/
        if (userResult != null){
            System.out.println(userResult.getAccount() + "登录成功，欢迎您！");
            result = true;
        }else {
            System.out.println("登陆失败,您输入的账号或密码有错误！");
            result = false;
        }
        return result;
    }
}
