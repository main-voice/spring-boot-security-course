package com.example.demo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.Permission.*;

/**
 * @program: spring-boot-security-course
 * @description: roles for users
 * @packagename: com.example.demo.security
 * @author: peng peng
 * @date: 2022-11-30 11:03
 **/

public enum Role {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
