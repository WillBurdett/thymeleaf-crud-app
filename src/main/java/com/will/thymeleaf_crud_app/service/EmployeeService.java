package com.will.thymeleaf_crud_app.service;

import com.will.thymeleaf_crud_app.model.Employee;
import java.util.List;

public interface EmployeeService {

  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);
  Employee getEmployeeById(long id);
  void deleteEmployeeById(long id);

}
