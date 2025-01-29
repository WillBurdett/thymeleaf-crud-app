package com.will.thymeleaf_crud_app.service;

import com.will.thymeleaf_crud_app.model.Employee;
import com.will.thymeleaf_crud_app.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee){
    employeeRepository.save(employee);
  }

}
