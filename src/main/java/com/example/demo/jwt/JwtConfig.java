package com.example.demo.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.jwt
 * @author: peng peng
 * @date: 2022-12-01 20:44
 **/
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

}
