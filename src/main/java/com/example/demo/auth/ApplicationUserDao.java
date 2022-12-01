package com.example.demo.auth;

import java.util.Optional;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.auth
 * @author: peng peng
 * @date: 2022-12-01 16:00
 **/

// this interface will make it very easy to switch to another database source
public interface ApplicationUserDao {
    Optional<ApplicationUser> selectAppUserByUsername(String username);
}
