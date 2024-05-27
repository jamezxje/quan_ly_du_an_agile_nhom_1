package org.nhom1.agilecarrentall.entity.dto.filter;

import lombok.*;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.type.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarFilterRequest extends PaginationRequest {
    public Integer ownerId;
    public String carModel;
    public Integer brandId;
    public Status status;
}
