package com.example.demo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.student
 * @author: peng peng
 * @date: 2022-11-30 12:55
 **/

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping(path = "all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public static List<Student> getSTUDENTS() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerStudent(@RequestBody Student student) {
        System.out.println("register : ");
        System.out.println(student.toString());
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") Integer id) {
        System.out.println("delete : ");
        System.out.println(id);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("id") Integer id,
                              @RequestBody Student student) {
        System.out.println("update : ");

        System.out.println(id);
        System.out.println(student.toString());
    }

}
