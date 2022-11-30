package com.example.demo.security;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.security
 * @author: peng peng
 * @date: 2022-11-30 11:04
 **/
public enum Permission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
