package com.example.tareaclase3.controller;

import com.example.tareaclase3.repository.EmployeeRepository;
import com.example.tareaclase3.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @GetMapping
    public String index() {
        return "search/index";
    }

    @GetMapping("/highsalary")
    public String employeesWithHighSalary(Model model) {
        model.addAttribute("list", employeeRepo.findEmployeesWithSalaryGreaterThan(15000));
        return "search/highsalary";
    }

    @GetMapping("/departments")
    public String departmentsWithMoreThan3Employees(Model model) {
        model.addAttribute("list", departmentRepo.findDepartmentsWithMoreThan3Employees());
        return "search/departments";
    }

    @GetMapping("/experienced-managers")
    public String experiencedManagers(Model model) {
        model.addAttribute("list", employeeRepo.findExperiencedManagers());
        return "search/experienced_managers";
    }
}
