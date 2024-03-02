package com.hans.works.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 직원 이름

    @ManyToOne
    @JoinColumn(nullable = false, name = "team_name")
    private Team team;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role; // 역할

    @Column(nullable = false)
    private LocalDate workStartDate; // 입사일

    @Column(nullable = false)
    private LocalDate birthday; // 생일

    public void changeRole(Role role) {
        this.role = role;
    }
}
