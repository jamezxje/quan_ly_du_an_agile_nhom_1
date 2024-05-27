package org.nhom1.agilecarrentall.entity.dto.filter;

import lombok.Getter;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.type.TransmissionType;

@Getter
@Setter
public class CarFilterSearchSortDTO extends PaginationRequest {

	private String keyword;

	private Double minPrice = 0.0;

	private Double maxPrice = 1000.0;

	private Integer brandId;

	private Integer numberOfSeats;

	private TransmissionType transmissionType;

}
