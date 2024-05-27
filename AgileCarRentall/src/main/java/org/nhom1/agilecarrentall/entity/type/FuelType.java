package org.nhom1.agilecarrentall.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuelType {
    PETROL ("Petrol"),
    DIESEL ("Diesel"),
    ELECTRIC ("Electric"),
    HYBRID ("Hybrid");

    private final String type;
}
