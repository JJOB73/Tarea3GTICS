package com.example.tareaclase3.controller;


import com.example.tareaclase3.entity.Employee;
import com.example.tareaclase3.entity.Department;
import com.example.tareaclase3.entity.Job;
import com.example.tareaclase3.repository.EmployeeRepository;
import com.example.tareaclase3.repository.DepartmentRepository;
import com.example.tareaclase3.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private JobRepository jobRepo;

    @GetMapping
    public String listEmployees(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Employee> employees = (search == null || search.isEmpty())
                ? employeeRepo.findAll()
                : employeeRepo.findBySearch(search.toLowerCase());
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentRepo.findAll());
        model.addAttribute("jobs", jobRepo.findAll());
        model.addAttribute("managers", employeeRepo.findAll());
        return "employee/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "employee/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentRepo.findAll());
        model.addAttribute("jobs", jobRepo.findAll());
        model.addAttribute("managers", employeeRepo.findAll());
        return "employee/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeRepo.deleteById(id);
        return "redirect:/employees";
    }


}


