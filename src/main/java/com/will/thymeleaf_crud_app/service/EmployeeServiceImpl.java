package com.will.thymeleaf_crud_app.service;

import com.will.thymeleaf_crud_app.model.Employee;
import com.will.thymeleaf_crud_app.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  @Override
  public Employee getEmployeeById(long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    if (employee.isPresent()) {
      return employee.get();
    } else {
      throw new RuntimeException("Employee not found for ID :: " + id);
    }
  }

  @Override
  public void deleteEmployeeById(long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public Page<Employee> findPaginated(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return employeeRepository.findAll(pageable);
  }


}
