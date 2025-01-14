package com.vaishnavi.EmployeeManagement1.Repo;

import com.vaishnavi.EmployeeManagement1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // Corrected query for finding by username and password
    @Query("SELECT e FROM Employee e WHERE e.username = :username and e.password1 = :password1")
    Employee findByUsernameAndPassword1(String username, String password1);

    // Corrected query for finding by jobRole
    @Query("SELECT e FROM Employee e WHERE e.jobRole = :jobRole")
    List<Employee> findByJobRole(String jobRole);

    // Corrected query for finding by designation
    @Query("SELECT e FROM Employee e WHERE e.designation = :designation")
    List<Employee> findByDesignation(String designation);

    // Corrected query for finding by jobRole and designation
    @Query("SELECT e FROM Employee e WHERE e.jobRole = :jobRole and e.designation = :designation")
    List<Employee> findByJobRoleAndDesignation(String jobRole, String designation);

    Optional<Employee> findById(Long id);
}

