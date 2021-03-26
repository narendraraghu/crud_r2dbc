package com.narendra.r2dbc.repository;

import com.narendra.r2dbc.entity.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
    @Query("select * from Employee where company_id = :id")
    Flux<Employee> findEmployeeByCompanyId(String id);


    @Query("INSERT INTO employee(id, name, department, company_id) VALUES($1, $2, $3,$4)")
    Mono<Employee> saveEmployee(Long id, String name, String department, String company_id);

}
