package com.will.thymeleaf_crud_app.service;

import com.will.thymeleaf_crud_app.model.Employee;
import java.util.List;
import org.springframework.data.domain.Page;

public interface EmployeeService {

  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);
  Employee getEmployeeById(long id);
  void deleteEmployeeById(long id);
  Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
