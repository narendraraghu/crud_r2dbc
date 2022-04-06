package com.narendra.r2dbc.controller;


import com.narendra.r2dbc.entity.Employee;
import com.narendra.r2dbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Mono<Employee> saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/save")
    public Mono<Employee> saveEmployee1(@RequestBody Employee employee) {
        System.out.println(" Employee " + employee.getId() + " " + employee.getName() + " " + employee.getDepartment() + " " + employee.getCompanyId());
        return employeeRepository.saveEmployee(employee.getId(), employee.getName(), employee.getDepartment(), employee.getCompanyId(), employee.getAge());
    }


    @GetMapping("/{id}")
    public Mono<ResponseEntity<String>> findOne(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .map(savedTweet -> ResponseEntity.ok(" Found "))
                .defaultIfEmpty(new ResponseEntity<>(new String("Not Found"), HttpStatus.NOT_FOUND));

    }

    @PutMapping
    public Mono<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public Mono<Employee> deleteEmployee(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .doOnSuccess(employee -> employeeRepository.delete(employee).subscribe());
    }

    @GetMapping
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/c/{cid}")
    public Flux<Employee> findByCompany(@PathVariable("cid") String cmpanyID) {

        return employeeRepository.findEmployeeByCompanyId(cmpanyID);

    }

    @GetMapping("/age/{age}")
    public Flux<Employee> findByAge(@PathVariable("age") int age) {
        Flux<Employee> emp = employeeRepository.findEmployeeByAge(age);
        emp.subscribe(employee ->
        {
            System.out.println(("Finished processing Foo with Id {}"+ employee.getId()));
        });
        return emp;
    }
}
