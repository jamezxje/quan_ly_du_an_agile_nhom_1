package org.nhom1.agilecarrentall.entity.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.type.TransactionStatus;
import org.nhom1.agilecarrentall.entity.type.TransactionType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilterRequest extends PaginationRequest {
    private String memberName;
    private Integer memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private TransactionType type;
    private TransactionStatus status;

    public LocalDateTime toStartLocalDateTime() {
        return startDate != null ? startDate.atStartOfDay() : null;
    }

    public LocalDateTime toEndLocalDateTime() {
        return endDate != null ? endDate.atStartOfDay() : null;
    }
}
