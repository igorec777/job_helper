package com.helper.job.jobHelper.service;

import com.helper.job.jobHelper.connector.RabotaByConnector;
import com.helper.job.jobHelper.dto.rabotaby.KeySkills;
import com.helper.job.jobHelper.dto.rabotaby.RabotaByVacancies;
import com.helper.job.jobHelper.dto.rabotaby.RabotaByVacancy;
import com.helper.job.jobHelper.enums.PositionName;
import com.helper.job.jobHelper.model.Skill;
import com.helper.job.jobHelper.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final RabotaByConnector rabotaByConnector;
    private final SkillService skillService;

    public void executeSearching(PositionName positionName) {
        collectSkillsFromRabotaBy(positionName);
    }

    private void collectSkillsFromRabotaBy(PositionName positionName) {
        List<String> vacancyIds = rabotaByConnector.getVacancies(positionName)
                .getVacancies().stream()
                .map(RabotaByVacancy::getId)
                .toList();

        Set<String> foundedSkills = new HashSet<>();

        for (String vacancyId: vacancyIds) {
            RabotaByVacancy vacancy = rabotaByConnector.getVacancyById(vacancyId);
            foundedSkills.addAll(getSkillsNamesFromVacancy(vacancy));
        }

        removeExistingSkills(foundedSkills);

        skillService.addSkills(foundedSkills);
    }

    private Set<String> getSkillsNamesFromVacancy(RabotaByVacancy vacancy) {
        return vacancy.getKeySkills().stream()
                .map(KeySkills::getSkillName)
                .collect(Collectors.toSet());
    }

    private void removeExistingSkills(Set<String> foundedSkills) {
        Set<String> existingSkills = skillService.findAll().stream()
                .map(Skill::getName)
                .collect(Collectors.toSet());

        foundedSkills.removeAll(existingSkills);
    }
}
