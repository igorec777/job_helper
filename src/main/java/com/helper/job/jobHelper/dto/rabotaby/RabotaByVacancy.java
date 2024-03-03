package com.helper.job.jobHelper.dto.rabotaby;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RabotaByVacancy {

    private String id;

    @JsonProperty("key_skills")
    private List<KeySkills> keySkills;
}
