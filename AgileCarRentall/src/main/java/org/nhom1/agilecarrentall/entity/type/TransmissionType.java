package org.nhom1.agilecarrentall.entity.type;

import lombok.Getter;

@Getter
public enum TransmissionType {
    AUTOMATIC ("Automatic"),
    MANUAL ("Manual");

    private final String type;
    TransmissionType(String type) {
        this.type = type;
    }
}
