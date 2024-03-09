package com.hans.works.dto.request.work;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class WorkEndRequest {

    private Long employeeId;
    private LocalDate workDate;
}
