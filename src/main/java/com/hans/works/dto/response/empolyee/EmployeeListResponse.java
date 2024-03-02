package com.hans.works.dto.response.empolyee;

import com.hans.works.domain.Employee;
import com.hans.works.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmployeeListResponse {
    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public EmployeeListResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = employee.getTeam().getName();
        this.role = employee.getRole();
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }
}
