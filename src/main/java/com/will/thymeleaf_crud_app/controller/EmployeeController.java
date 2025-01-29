package com.will.thymeleaf_crud_app.controller;

import com.will.thymeleaf_crud_app.model.Employee;
import com.will.thymeleaf_crud_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String viewHomePage(Model model){
    model.addAttribute("listEmployees", employeeService.getAllEmployees());
    return "index";
  }

  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model) {
    Employee employee = new Employee();
    // thymeleaf template will access this empty employee object for binding form data
    model.addAttribute("employee", employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    // save employee to database
    employeeService.saveEmployee(employee);
    return "redirect:/";
  }

}
