package com.hans.works.service.employee;

import com.hans.works.domain.Employee;
import com.hans.works.domain.Role;
import com.hans.works.domain.Team;
import com.hans.works.dto.request.employee.EmployeeAddRequest;
import com.hans.works.dto.response.empolyee.EmployeeListResponse;
import com.hans.works.repository.employee.EmployeeRepository;
import com.hans.works.repository.team.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    /**
     * 직원을 등록한다.
     * @param request
     */
    @Transactional
    public void addEmployee(EmployeeAddRequest request) {
        // team 객체 가져오기
        Team team = teamRepository.findById(request.getTeamName())
                .orElseThrow(IllegalArgumentException::new);

        employeeRepository.save(Employee.builder()
                                .name(request.getName())
                                .team(team)
                .role(request.getRole())
                .workStartDate(request.getWorkStartDate())
                .birthday(request.getBirthday()).build());

        // 만약 역할이 매니저면 team에 manager 등록
        if(request.getRole() == Role.MANAGER) {
            team.setManager(request.getName());
        }

        //팀 인원 수 + 1
        team.addMember();
    }

    /**
     * 모든 직원을 조회한다.
     * @return List
     */
    public List<EmployeeListResponse> getEmployeeList() {
        return employeeRepository.findAll().stream()
                .map(EmployeeListResponse::new)
                .collect(Collectors.toList());
    }
}
