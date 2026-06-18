package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee() {}

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

@RestController
@RequestMapping("/employees")
class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Employee Added Successfully";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @RequestBody Employee employee) {

        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(employee.getName());
                e.setDepartment(employee.getDepartment());
                return "Employee Updated Successfully";
            }
        }
        return "Employee Not Found";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee e = iterator.next();

            if (e.getId() == id) {
                iterator.remove();
                return "Employee Deleted Successfully";
            }
        }

        return "Employee Not Found";
    }
}

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }
}