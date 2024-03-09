package com.hans.works.dto.request.work;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class WorkStartRequest {

    private Long employeeId;
    private LocalDate workDate;
}
