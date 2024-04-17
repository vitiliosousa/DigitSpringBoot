package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }
    public Employee create(Employee employee) {
        Employee saveEmployee=employeeRepository.save(employee);

        return saveEmployee;
    }

    public List<Employee> searchAll(){
        return employeeRepository.findAll();
    }
    public Employee searchById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if(employee==null) {
            //Throw an Error
        }
        return employee;
    }
    public Employee update(Long employeeId, Employee employeeDetais) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if(employee == null) {
            //Throw an Error
        }
        employee.setFirstName(employeeDetais.getFirstName());
        employee.setLastName(employeeDetais.getLastName());
        employee.setEmailId(employeeDetais.getEmailId());
        Employee updateEmployee = employeeRepository.save(employee);
        return updateEmployee;
    }
}

