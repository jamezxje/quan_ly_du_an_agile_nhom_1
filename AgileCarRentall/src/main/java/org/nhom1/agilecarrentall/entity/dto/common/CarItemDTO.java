package org.nhom1.agilecarrentall.entity.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.type.Status;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarItemDTO {
    private Integer carId;
    private String carModel;
    private String brandName;
    private String featureImageUrl;
    private String carLicensePlate;
    private String ownerName;
    private Status status;
    private Integer productionYear;
    private Double basePrice;
}
