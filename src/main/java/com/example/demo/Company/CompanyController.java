package com.example.demo.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    List<Company> get(@RequestParam(name = "userId" , required = false , defaultValue = "") String userId) {
        return companyService.get(userId);
    }


    @GetMapping("/companies/{id}")
    Company getById(@PathVariable int id){
        return companyService.getById(id);
    }




}
