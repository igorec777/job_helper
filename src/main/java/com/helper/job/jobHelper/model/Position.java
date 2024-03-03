package com.helper.job.jobHelper.model;

import com.helper.job.jobHelper.enums.PositionName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position_name")
    @Enumerated(value = EnumType.STRING)
    private PositionName positionName;

    private LocalDateTime created = LocalDateTime.now();
}
