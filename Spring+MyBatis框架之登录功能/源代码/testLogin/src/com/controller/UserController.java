package com.controller;

import java.util.Random;
import java.util.Scanner;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

//Controller层
@Controller("userController")
public class UserController {
    //定义静态变量，用于接收输入的字符串信息
    public static String input_account;
    public static String input_password;
    @Autowired
    private UserService userService;

    public void controllerLogin() {
        //构造一个Scanner类的对象，并且与标准输入流System.in关联
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;   //定义一个布尔型变量，赋初值为false
        while (!flag) {     //当flag为true时，一直循环执行
            System.out.println("----欢迎使用登录系统----");
            System.out.print("请输入用户名：");
            input_account = scanner.next();
            scanner.nextLine();
            System.out.print("请输入密码：");
            input_password = scanner.next();
            scanner.nextLine();
            System.out.print("验证码：");
            String str="0123456789";    //定义一个字符串
            Random random = new Random();   //创建一个随机数对象
            StringBuilder stringBuilder = new StringBuilder();   //创建StringBuilder对象
            for(int i=0;i<4;i++){   //随机生成一个四位数的验证码
               /* random.nextInt(10)方法的作用是生成一个随机的int值，
                该值介于[0,10)的区间，包含0而不包含10*/
                int number=random.nextInt(10);
                /*str.charAt(number),通过一个number随机数，返回str字符串中位于number位置的字符，
                测试语句：System.out.println(number + ": " + str.charAt(number));*/
                stringBuilder.append(str.charAt(number)); //将str.charAt(number)方法生成的字符连接起来
            }
            System.out.println(stringBuilder.toString());   //返回append方法构建的字符串
            System.out.print("请输入验证码：");
            String code = scanner.nextLine();
            if (code.equals(stringBuilder.toString())) {    //判断输入的验证是否正确
                /*接收Service层UserService类的userService对象调用方法返回的结果，
            判断程序是否继续执行*/
                flag = userService.Login();
            }else {
                System.out.println("验证码错误，请重新登录！");
                flag = false;   //继续执行程序
            }
        }
        scanner.close();  //关闭输入流，目的是为了节省内存，减少计算机的内存负担
    }
}