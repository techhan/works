package com.hans.works.controller.team;

import com.hans.works.dto.response.team.TeamListResponse;
import com.hans.works.service.team.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public void addTeam(@RequestParam String name) {
        teamService.addTeam(name);
    }

    @GetMapping("/teams")
    public List<TeamListResponse> getTeamList() {
        return teamService.getTeamList();
    }
}
