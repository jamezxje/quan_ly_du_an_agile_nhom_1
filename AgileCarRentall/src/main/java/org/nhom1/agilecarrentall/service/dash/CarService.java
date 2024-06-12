package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.dto.common.CarItemDTO;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.CarRequestDTO;
import org.nhom1.agilecarrentall.entity.dto.filter.CarFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.front.response.CarItemResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.RatingDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.RatingDetailResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationResponse;
import org.nhom1.agilecarrentall.entity.type.Status;

import java.util.List;

public interface CarService {
    PaginationResponse<List<CarItemDTO>> findByFilter(CarFilterRequest request);
    void addCar(CarRequestDTO request);
    void editCar(CarRequestDTO request);
    CarRequestDTO findById(Integer id);
    void changeStatus(Integer id, Status status);
    CarItemResponseDTO findCarItemByCarId(Integer memberId,Integer carId);

    RatingDTO findTotalRatingAndAvgRatingByCarId(Integer carId);

    PaginationResponse<List<RatingDetailResponseDTO>> findAllRatingByCarId(Integer carId, PaginationRequest request);
}
