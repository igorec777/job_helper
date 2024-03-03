package com.helper.job.jobHelper.service;

import com.helper.job.jobHelper.model.Skill;
import com.helper.job.jobHelper.repository.SkillRepository;
import com.helper.job.jobHelper.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DefaultSkillService implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public void addSkills(Set<String> skillNames) {
        List<Skill> skills = new ArrayList<>();

        skillNames.forEach(skillName -> skills.add(buildByName(skillName)));

        skillRepository.saveAll(skills);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    private Skill buildByName(String skillName) {
        Skill skill = new Skill();
        skill.setName(skillName);
        return skill;
    }
}
