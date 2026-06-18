package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

class Student {
    private int id;
    private String name;
    private String course;

    public Student() {}

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}

@RestController
@RequestMapping("/student")
class StudentController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Student Management REST API";
    }

    @GetMapping("/details")
    public Student getStudent() {
        return new Student(101, "Mohammad Zaid", "B.Tech CSE");
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return "Student Added Successfully : " + student.getName();
    }
}

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}