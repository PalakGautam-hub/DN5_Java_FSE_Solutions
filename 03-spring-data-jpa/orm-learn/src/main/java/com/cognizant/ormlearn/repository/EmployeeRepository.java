package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // HQL / JPQL with fetch joins to load department and skills in one query
    @Query("SELECT DISTINCT e FROM Employee e " +
           "LEFT JOIN FETCH e.department " +
           "LEFT JOIN FETCH e.skillList " +
           "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Native query example
    @Query(value = "SELECT * FROM employee WHERE em_salary > ?1", nativeQuery = true)
    List<Employee> getEmployeesWithSalaryGreaterThan(Double salary);
}
