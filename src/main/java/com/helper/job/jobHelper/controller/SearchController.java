package com.helper.job.jobHelper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helper.job.jobHelper.enums.PositionName;
import com.helper.job.jobHelper.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/vacancies")
    private void searchVacanciesData(@RequestParam("positionName") PositionName positionName) {
        searchService.executeSearching(positionName);
    }
}
