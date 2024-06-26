package org.nhom1.agilecarrentall.service.dash.impl;

import org.nhom1.agilecarrentall.entity.Car;
import org.nhom1.agilecarrentall.entity.Image;
import org.nhom1.agilecarrentall.entity.dto.common.CarItemDTO;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.CarRequestDTO;
import org.nhom1.agilecarrentall.entity.dto.filter.CarFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.front.response.CarItemResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.RatingDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.RatingDetailResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationRequest;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationResponse;
import org.nhom1.agilecarrentall.entity.type.Status;
import org.nhom1.agilecarrentall.repository.CarRepo;
import org.nhom1.agilecarrentall.repository.ImageRepo;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.nhom1.agilecarrentall.service.common.FilesStorageService;
import org.nhom1.agilecarrentall.service.dash.BrandService;
import org.nhom1.agilecarrentall.service.dash.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;
    private final BrandService brandService;
    private final MemberRepo memberRepo;
    private final ImageRepo imageRepo;
    private final FilesStorageService filesStorageService;

    @Override
    public PaginationResponse<List<CarItemDTO>> findByFilter(CarFilterRequest request) {
        Pageable pageable = PageRequest.of(request.getPageIndex(), request.getPageSize());
        Page<CarItemDTO> cars = carRepo.findByFilter(request.getCarModel(),request.getBrandId(),request.getStatus(),request.getOwnerId(),pageable);
        return new PaginationResponse<>(cars.getContent(), request.getPageIndex() + 1, cars.getTotalPages() + 1, cars.getTotalElements(),request.getPageSize());
    }

    @Override
    public void addCar(CarRequestDTO request) {
        Car car = request.toEntity();
        car.setOwner(memberRepo.findById(request.getOwnerId()).orElseThrow(() -> new RuntimeException("Owner not found")));
        car.setBrand(brandService.findBrandById(request.getBrandId()));
        Image featureImage = filesStorageService.save(request.getFeatureImage());
        car.setFeatureImage(featureImage);
        List<Image> images = filesStorageService.saveAll(request.getImages());
        car.setImages(images);
        carRepo.save(car);
    }

    @Override
    public void editCar(CarRequestDTO request) {
        Car car = carRepo.findById(request.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        request.updateEntity(car);
        car.setBrand(brandService.findBrandById(request.getBrandId()));

        if (request.getFeatureImage() != null && !request.getFeatureImage().isEmpty()) {
            Image featureImage = filesStorageService.save(request.getFeatureImage());
            filesStorageService.delete(car.getFeatureImage());
            car.setFeatureImage(featureImage);
        }

        if (request.getDeleteImagesUrl() != null && !request.getDeleteImagesUrl().isEmpty()) {
            List<Image> deleteImages = imageRepo.findByImageUrl(request.getDeleteImagesUrl());
            filesStorageService.deleteAll(deleteImages);
            car.getImages().removeAll(deleteImages);
        }

        if (request.getImages() != null ) {
            List<Image> images = filesStorageService.saveAll(request.getImages());
            car.getImages().addAll(images);
        }
        carRepo.save(car);
    }

    @Override
    public CarRequestDTO findById(Integer id) {
        Car car = carRepo.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        return CarRequestDTO.toDTO(car);
    }

    @Override
    public void changeStatus(Integer id, Status status) {
        Car car = carRepo.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setStatus(status);
        carRepo.save(car);
    }

    @Override
    public CarItemResponseDTO findCarItemByCarId(Integer memberId, Integer carId ) {
        return carRepo.findCarItemByMemberIdAndCarId(memberId, carId);
    }

    public RatingDTO findTotalRatingAndAvgRatingByCarId(Integer carId) {
        return carRepo.findTotalRatingAndAvgRatingByCarId(carId);
    }

    @Override
    public PaginationResponse<List<RatingDetailResponseDTO>> findAllRatingByCarId(Integer carId, PaginationRequest request) {
        Pageable pageable = PageRequest.of(request.getPageIndex(), request.getPageSize());
        Page<RatingDetailResponseDTO> responseDTOS =  carRepo.findAllRatingDetailByCarId(carId,pageable);
        return new PaginationResponse<>(responseDTOS.getContent(), request.getPageIndex() + 1
                , responseDTOS.getTotalPages() + 1, responseDTOS.getTotalElements(),request.getPageSize());
    }

}
