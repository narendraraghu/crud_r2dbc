package com.narendra.r2dbc.repository;

import com.narendra.r2dbc.entity.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
    @Query("select * from Employee where company_id = :id")
    Flux<Employee> findEmployeeByCompanyId(String id);


    @Query("INSERT INTO employee(id, name, department, company_id,age) VALUES($1, $2, $3,$4,$5)")
    Mono<Employee> saveEmployee(String id, String name, String department, String company_id,Integer age);


    @Query(value = "select * from GetEmployeeById(:age)")
    Flux<Employee> findEmployeeByAge(@Param("age")int age);

    @Query(value = "select * from GetEmployeeByDepartment(:dept)")
    Flux<Employee> findEmployeeByDepartment(@Param("dept")String dept);

}
