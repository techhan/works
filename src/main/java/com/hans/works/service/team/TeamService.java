package com.hans.works.service.team;

import com.hans.works.domain.Team;
import com.hans.works.dto.response.team.TeamListResponse;
import com.hans.works.repository.team.TeamRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * 새로운 팀을 등록한다.
     * @param name
     */
    @Transactional
    public void addTeam(String name) {

        if(name == null || name.isBlank()) throw new IllegalArgumentException("팀 이름은 빈 값을 저장할 수 없습니다.");

        boolean isDuplicate = teamRepository.existsById(name);
        if(isDuplicate) throw new IllegalArgumentException("팀 이름이 중복되었습니다.");
        teamRepository.save(Team.builder().name(name).build());
    }

    /**
     * 모든 팀을 조회한다.
     * @return List
     */
    @Transactional(readOnly = true)
    public List<TeamListResponse> getTeamList() {
        return teamRepository.findAll().stream()
                .map(TeamListResponse::new)
                .collect(Collectors.toList());
    }
}
