package com.hans.works.dto.response.empolyee;

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
}
