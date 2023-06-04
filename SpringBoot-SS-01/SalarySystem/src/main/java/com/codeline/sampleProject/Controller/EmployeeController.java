package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.RequestObjects.GetEmployeeRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("create")
    public void saveEmployee(@RequestBody GetEmployeeRequestObject employeeRequestObject) {
        createEmployee(employeeRequestObject);
    }

    @RequestMapping("get")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    //Path Variable
    @RequestMapping("get/{employeeId}")
    public GetEmployeeResponse createEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    public void createEmployee(GetEmployeeRequestObject employeeRequestObject) {

        Employee employee = new Employee();
        employee.setName(employeeRequestObject.getName());
        employee.setSalary(employeeRequestObject.getSalary());
        employee.setDepartment("Software Developer");
        employee.setCompanyName("The Moon");
        employee.setCreatedDate(new Date());
        employee.setIsActive(true);
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "getByDepartment")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam String departmentName) {
        return employeeService.getEmployeesByDept(departmentName);
    }
}
