package com.example.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.security.controller
 * @author: peng peng
 * @date: 2022-12-01 14:21
 **/

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }
}
