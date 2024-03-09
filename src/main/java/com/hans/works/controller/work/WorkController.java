package com.hans.works.controller.work;

import com.hans.works.dto.request.work.WorkEndRequest;
import com.hans.works.dto.request.work.WorkStartRequest;
import com.hans.works.service.work.WorkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/startWork")
    public void startWork(@RequestBody WorkStartRequest request) {
        workService.startWork(request);
    }

    @PutMapping("/endWork")
    public void endWork(@RequestBody WorkEndRequest request) {
        workService.endDate(request);
    }
}
