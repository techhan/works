package com.hans.works.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @Column(nullable = false)
    private String name; // 팀 이름
    private String manager; // 팀 매니저 이름
    private int memberCount; // 팀 인원 수

    @OneToMany(mappedBy = "team")
    private List<Employee> employees = new ArrayList<>();

    public void setManager(String name) {
        changeRole();
        this.manager = name;
    }

    public void addMember() {
        this.memberCount++;
    }

    private void changeRole() {
        if(this.manager == null) return;

        Employee findEmployee = this.employees.stream()
                .filter(employee -> employee.getRole() == Role.MANAGER)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        findEmployee.changeRole(Role.MEMBER);
    }
}
