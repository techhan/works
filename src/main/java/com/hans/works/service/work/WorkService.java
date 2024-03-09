package com.hans.works.service.work;

import com.hans.works.domain.Employee;
import com.hans.works.domain.Work;
import com.hans.works.dto.request.work.WorkEndRequest;
import com.hans.works.dto.request.work.WorkStartRequest;
import com.hans.works.repository.employee.EmployeeRepository;
import com.hans.works.repository.work.WorkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WorkService {

    private final WorkRepository workRepository;
    private final EmployeeRepository employeeRepository;

    public WorkService(WorkRepository workRepository, EmployeeRepository employeeRepository) {
        this.workRepository = workRepository;
        this.employeeRepository = employeeRepository;
    }

    /**
     * 직원의 출근 정보를 저장한다.
     * @param request
     */
    @Transactional
    public void startWork(WorkStartRequest request) {

        Employee findEmployee = existsEmployeeCheck(request.getEmployeeId());

        Work newWork = new Work(request);

        if(workRepository.existsByWorkDateAndEmployeeId(newWork.getWorkDate(), request.getEmployeeId()))
        {
            throw new IllegalArgumentException(String.format("[%s] 해당 날짜에 출근 처리가 이미 완료되었습니다.", newWork.getWorkDate()));
        }

        newWork.addEmployee(findEmployee);

        workRepository.save(newWork);
    }

    /**
     * 직원의 퇴근 정보를 저장한다.
     * @param request
     */
    @Transactional
    public void endDate(WorkEndRequest request) {
        existsEmployeeCheck(request.getEmployeeId());

        Work newWork = new Work(request);

        Work findWork = workRepository.findByWorkDateAndEmployeeId(newWork.getWorkDate(), request.getEmployeeId())
                .orElseThrow(()
                        -> new IllegalArgumentException(String.format("[%s] 해당 날짜에 출근 처리가 되지 않아 퇴근 처리가 불가능합니다.",newWork.getWorkDate())));

        findWork.setEndData();

        // 근무 시간 저장
        findWork.CalculateWorkingMinutes();
    }

    /**
     * 파라미터로 넘어온 직원의 id로 직원이 존재하는지 조회
     * @param employeeId
     * @return
     */
    public Employee existsEmployeeCheck(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()
                -> new IllegalArgumentException(String.format("등록되지 않은 직원 id(%d) 입니다.", employeeId)));
    }

}
