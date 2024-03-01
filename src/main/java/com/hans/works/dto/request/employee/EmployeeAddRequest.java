package com.hans.works.dto.request.employee;

import com.hans.works.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmployeeAddRequest {

    private String name;
    private Role role;
    private String teamName;
    private LocalDate workStartDate;
    private LocalDate birthday;

}
