package com.hans.works.repository.work;

import com.hans.works.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkRepository extends JpaRepository<Work, Long> {

    boolean existsByWorkDateAndEmployeeId(LocalDate date, Long employeeId);

    Optional<Work> findByWorkDateAndEmployeeId(LocalDate workDate, Long employeeId);
}
