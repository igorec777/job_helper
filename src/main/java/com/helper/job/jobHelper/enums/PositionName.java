package com.helper.job.jobHelper.enums;

import lombok.Getter;

@Getter
public enum PositionName {
    DATA_ANALYSTS("Data analysts"),
    JAVA_DEVELOPER("Java developer");

    private final String text;

    PositionName(String text) {
        this.text = text;
    }
}
