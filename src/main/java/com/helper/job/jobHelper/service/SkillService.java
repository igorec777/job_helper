package com.helper.job.jobHelper.service;

import com.helper.job.jobHelper.model.Skill;

import java.util.List;
import java.util.Set;

public interface SkillService {
    void addSkills(Set<String> skillNames);

    List<Skill> findAll();
}
