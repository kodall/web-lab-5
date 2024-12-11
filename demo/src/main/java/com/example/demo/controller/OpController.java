package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.EmployeeService;

@Controller
public class OpController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("EmployeeList", employeeService.getAllEmployees());
        return "/index";
    }
    

    
}