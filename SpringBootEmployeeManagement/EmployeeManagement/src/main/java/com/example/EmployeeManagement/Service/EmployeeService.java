package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.Repository.EmployeeRepository;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public void addEmplooyee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
