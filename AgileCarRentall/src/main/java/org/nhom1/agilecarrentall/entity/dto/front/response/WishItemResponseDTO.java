package org.nhom1.agilecarrentall.entity.dto.front.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.type.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishItemResponseDTO {
    private Integer carId;
    private String imageUrl;
    private String carModel;
    private Integer numberOfSeats;
    private String carColor;
    private Double basePrice;
    private String imageAlt;
    private Status status;
}
