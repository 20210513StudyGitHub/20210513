package com.po;
/**
 * testlogin数据库中loginuser表的持久化类
 * POJO类
 */
public class UserInformation {
    private String account;    //用户名(主键)
    private String password;    //用户密码

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}