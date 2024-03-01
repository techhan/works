package com.hans.works.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // 팀 이름
    private String manager; // 팀 매니저 이름
    private int memberCount; // 팀 인원 수

}
