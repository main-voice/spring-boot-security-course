package com.example.demo.jwt;

/**
 * @program: spring-boot-security-course
 * @description: 用户发起认证请求，从认证请求中得到用户名和密码，这个类用来存这两个数据
 * @packagename: com.example.demo.jwt
 * @author: peng peng
 * @date: 2022-12-01 18:31
 **/
public class UserInfoFromAuthRequest {
    private String username;
    private String password;

    public UserInfoFromAuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
