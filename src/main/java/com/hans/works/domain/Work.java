package com.hans.works.domain;

import com.hans.works.dto.request.work.WorkEndRequest;
import com.hans.works.dto.request.work.WorkStartRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity @Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate workDate;

    private LocalTime startTime;

    private LocalTime endTime;
    private Long workingMinutes;

    @ManyToOne
    @JoinColumn(nullable = false, name = "employee_id")
    private Employee employee;

    public Work(WorkStartRequest request) {
        setWorkDate(request.getWorkDate());
        this.startTime = getNowTime();
    }

    public Work(WorkEndRequest request) {
        setWorkDate(request.getWorkDate());
        this.endTime = getNowTime();
    }

    public void setEndData() {
        this.endTime = getNowTime();
    }

    public void addEmployee(Employee employee) {
        this.employee = employee;
    }

    // insert 되기 전(persist 되기 전) 실행되는 메서드
    @PrePersist
    public void prePersist() {
        this.workingMinutes = (this.workingMinutes == null) ? 0L : this.workingMinutes;
    }

    // workDate 값 저장
    private void setWorkDate(LocalDate date) {
        if(date == null) {
            this.workDate = LocalDate.now();
        }
        else {
            this.workDate = date;
        }
    }

    // 현재 시간을 HH:mm 형식으로 반환
    private LocalTime getNowTime() {
        return LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    // 근무 시간 (startTime ~ endTime)을 저장한다.
    public void CalculateWorkingMinutes() {
        Duration diff = Duration.between(this.startTime, this.endTime);
        this.workingMinutes = diff.toMinutes();
    }
}
