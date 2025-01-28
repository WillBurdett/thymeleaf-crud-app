package com.will.thymeleaf_crud_app;

import com.will.thymeleaf_crud_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String viewHomePage(Model model){
    model.addAttribute("listEmployees", employeeService.getAllEmployees());
    return "index";
  }

}
