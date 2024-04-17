package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }
    @RequestMapping(value = "/_create", method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.OK).body(savedEmployee);
    }

    @RequestMapping(value = "/_search", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> searchAllEmployees() {
        List<Employee> employeeList=employeeService.searchAll();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }
    @RequestMapping(value = "/_search/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> searchById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeService.searchById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    @RequestMapping(value = "/_update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeService.update(employeeId,employeeDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updateEmployee);
    }

}
