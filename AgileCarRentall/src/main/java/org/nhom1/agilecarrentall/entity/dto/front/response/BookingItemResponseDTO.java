package org.nhom1.agilecarrentall.entity.dto.front.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.type.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingItemResponseDTO {
    private Integer bookingId;
    private String carModel;
    private String carFeatureImageUrl;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private Double totalPrice;
    private Status status;
}
