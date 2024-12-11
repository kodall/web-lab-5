package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/Employee/{empID}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer empID) {
        return employeeRepository.findById(empID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/newEmployee")
    public String newEmployee(@ModelAttribute Employee newEmployee) {
        employeeRepository.save(newEmployee);
        return "redirect:/";
    }

    @PostMapping("/uptEmployee/{empID}")
    Optional<Object> updateEmployee(@RequestBody Employee newEmployee, @PathVariable String empID) {
        try {
            Integer parsedEmployeeID = Integer.parseInt(empID);
            return employeeRepository.findById(parsedEmployeeID).map(emp -> {
                emp.setIsim(newEmployee.getIsim());
                emp.setSoyad(newEmployee.getSoyad());
                emp.setGorev(newEmployee.getGorev());
                emp.setYas(newEmployee.getYas());
                return employeeRepository.save(emp);
            });
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid empId format");
        }
    }

    @GetMapping("/delEmployee/{empID}")
    String deleteEmployee(@PathVariable Integer empID) {

        employeeRepository.deleteById(empID);
        return "redirect:/";
    }
}