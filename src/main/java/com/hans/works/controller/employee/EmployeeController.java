package com.hans.works.controller.employee;

import com.hans.works.dto.request.employee.EmployeeAddRequest;
import com.hans.works.dto.response.empolyee.EmployeeListResponse;
import com.hans.works.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody EmployeeAddRequest request) {
        employeeService.addEmployee(request);
    }

    @GetMapping("/employees")
    public List<EmployeeListResponse> getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
