package org.nhom1.agilecarrentall.entity.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.type.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingFilterRequest extends PaginationRequest
{
    public Integer carOwnerId;
    public String carModel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate pickupDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate returnDate;
    public Status status;

    public LocalDateTime toStartLocalDate() {
        return pickupDate != null ? pickupDate.atStartOfDay() : null;
    }

    public LocalDateTime toEndLocalDate() {
        return returnDate != null ? returnDate.atStartOfDay() : null;
    }
}
