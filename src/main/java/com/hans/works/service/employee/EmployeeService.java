package com.hans.works.service.employee;

import com.hans.works.dto.request.employee.EmployeeAddRequest;
import com.hans.works.dto.response.empolyee.EmployeeListResponse;
import com.hans.works.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(EmployeeAddRequest request) {
//        employeeRepository.save(new Employee(request.getName(), request.getRole()
//               ,request.getTeamName() , request.getWorkStartDate(), request.getBirthday()));
    }

    public List<EmployeeListResponse> getEmployeeList() {
        return null;
    }
}
