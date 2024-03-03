package com.helper.job.jobHelper.connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helper.job.jobHelper.dto.rabotaby.RabotaByVacancies;
import com.helper.job.jobHelper.dto.rabotaby.RabotaByVacancy;
import com.helper.job.jobHelper.enums.PositionName;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RabotaByConnector {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String RABOTA_BY_API_URL = "https://api.rabota.by";
    private static final int BELARUS_AREA_ID = 16;

    public RabotaByVacancies getVacancies(PositionName positionName) {
        String url = String.format(
                "%s/vacancies?text=%s&area=%s",
                RABOTA_BY_API_URL,
                positionName.getText(),
                BELARUS_AREA_ID
        );

        return restTemplate.getForObject(
                url,
                RabotaByVacancies.class
        );
    }

    public RabotaByVacancy getVacancyById(String id) {
        String url = RABOTA_BY_API_URL + "/vacancies/" + id;

        return restTemplate.getForObject(
                url,
                RabotaByVacancy.class
        );
    }

}
