package com.will.thymeleaf_crud_app.controller;

import com.will.thymeleaf_crud_app.model.Employee;
import com.will.thymeleaf_crud_app.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String viewHomePage(Model model){
    return findPaginated(1, model);
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

  @GetMapping("/showFormForUpdate/{id}")
  public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
    Employee employee = employeeService.getEmployeeById(id);

    // pre-populates the form with employee info
    model.addAttribute("employee", employee);
    return "update_employee";
  }

  @GetMapping("/deleteEmployee/{id}")
  public String deleteEmployeeById(@PathVariable (value = "id") long id) {
    employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }

  @GetMapping("/page/{pageNo}")
  public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
    int pageSize = 5;

    Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
    List<Employee> listEmployees = page.getContent();

    model.addAttribute("currentPage", pageNo);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("listEmployees", listEmployees);

    return "index";
  }

}
