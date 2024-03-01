package com.hans.works.dto.response.team;

import com.hans.works.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeamListResponse {

    private String name;
    private String manager;
    private int memberCount;

    public TeamListResponse(Team team) {
        this.name = team.getName();
        this.manager = team.getManager();
        this.memberCount = team.getMemberCount();
    }
}
