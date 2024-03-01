package com.ibcs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic-salary")

public class BasicSalaryController {
   // @Autowired
  //  private BasicSalaryService basicSalaryService;

    @PostMapping("/grade-six")
    public void setBasicSalaryForGradeSix(@RequestParam double basicSalary) {
      //  basicSalaryService.setBasicSalaryForGradeSix(basicSalary);

    }
}
