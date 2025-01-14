package com.vaishnavi.EmployeeManagement1.Service;

import com.vaishnavi.EmployeeManagement1.Entity.Employee;
import com.vaishnavi.EmployeeManagement1.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee registerEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee login(String username, String password1) {
        return employeeRepo.findByUsernameAndPassword1(username, password1);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found with ID: " + id));

        // Update only non-null fields to avoid overwriting with null
        if (updatedEmployee.getFullName() != null) employee.setFullName(updatedEmployee.getFullName());
        if (updatedEmployee.getEmail() != null) employee.setEmail(updatedEmployee.getEmail());
        if (updatedEmployee.getMobileNo() != null) employee.setMobileNo(updatedEmployee.getMobileNo());
        if (updatedEmployee.getDesignation() != null) employee.setDesignation(updatedEmployee.getDesignation());
        if (updatedEmployee.getJobRole() != null) employee.setJobRole(updatedEmployee.getJobRole());
        if (updatedEmployee.getUsername() != null) employee.setUsername(updatedEmployee.getUsername());
        if (updatedEmployee.getPassword1() != null) employee.setPassword1(updatedEmployee.getPassword1());

        return employeeRepo.save(employee);
    }


    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public List<Employee> findByJobRole(String jobRole) {
        return employeeRepo.findByJobRole(jobRole);
    }

    public List<Employee> findByDesignation(String designation) {
        return employeeRepo.findByDesignation(designation);
    }

    public List<Employee> findByJobRoleAndDesignation(String jobRole, String designation) {
        return employeeRepo.findByJobRoleAndDesignation(jobRole, designation);
    }

    public Employee findById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

}

