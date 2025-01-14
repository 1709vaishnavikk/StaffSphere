package com.vaishnavi.EmployeeManagement1.Controller;

import com.vaishnavi.EmployeeManagement1.Entity.Employee;
import com.vaishnavi.EmployeeManagement1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3006")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeService.registerEmployee(employee);
    }

    @PostMapping("/login")
    public Employee login(@RequestParam String username, @RequestParam String password1) {
        return employeeService.login(username, password1);
    }

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    @GetMapping("/byJobRoleAndDesignation")
    public List<Employee> getEmployeesByJobRoleAndDesignation(
            @RequestParam(required = false) String jobRole,
            @RequestParam(required = false) String designation) {
        if (jobRole != null && designation != null) {
            return employeeService.findByJobRoleAndDesignation(jobRole, designation);
        } else if (jobRole != null) {
            return employeeService.findByJobRole(jobRole);
        } else if (designation != null) {
            return employeeService.findByDesignation(designation);
        } else {
            return employeeService.getAllEmployees(); // Return all employees if no filters are provided
        }
    }

    @CrossOrigin(origins = "http://localhost:3006")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        System.out.println("Received ID: " + id); // Debugging
        return employeeService.findById(id); // Assuming employeeService has the method to find employee by ID
    }


}


