package com.example.tareaclase3.controller;

import com.example.tareaclase3.entity.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showConfigPage() {
        return "index";
    }


}
