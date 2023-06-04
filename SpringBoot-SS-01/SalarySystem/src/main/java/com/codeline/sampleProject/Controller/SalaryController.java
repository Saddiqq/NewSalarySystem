package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.RequestObjects.GetEmployeeRequestObject;
import com.codeline.sampleProject.RequestObjects.GetSalaryRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import com.codeline.sampleProject.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @PostMapping("salary/create")
    public void saveSalary (@RequestBody GetSalaryRequestObject salaryRequestObject) {
        createSalary(salaryRequestObject);
    }

    @GetMapping("salary/get")
    public List<Salary> getSalary () {
        return salaryService.getSalary();
    }

    //Path Variable
    @GetMapping("salary/get/{salaryId}")
    public GetSalaryResponse createSalary (@PathVariable Long salaryId) {
        return salaryService.getSalaryById(salaryId);
    }

//    @PutMapping("salary/update/{salaryId}")
//    public GetSalaryResponse updateSalary(@PathVariable Long salaryId){
//        return  salaryService.getSalaryById(salaryId);
//
//    }

    public void createSalary(GetSalaryRequestObject salaryRequestObject) {

        Salary salary = new Salary();
        salary.setAmount(salaryRequestObject.getAmount());
        salary.setCurrency("OMR");
        salary.setAllowances(200.0);
        salary.setCreatedDate(new Date());
        salary.setIsActive(true);
        salaryService.saveSalary(salary);
    }
}
