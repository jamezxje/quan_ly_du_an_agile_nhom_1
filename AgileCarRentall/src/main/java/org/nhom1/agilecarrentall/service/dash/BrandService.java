package org.nhom1.agilecarrentall.service.dash;


import org.nhom1.agilecarrentall.entity.Brand;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.BrandRequestDTO;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.BrandResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.BrandDetailResponseDTO;
import org.nhom1.agilecarrentall.entity.dto.front.response.BrandItemResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrand();

    Page<BrandResponseDTO> findAllBrandResponseDTO(Pageable pageable);

    List<BrandItemResponseDTO> findAllBrandItemResponseDTO();

    void saveBrand(BrandRequestDTO request);

    void editBrand(BrandRequestDTO request);

    BrandRequestDTO findBrandDTOById(Integer brandId);

    Brand findBrandById(Integer brandId);

    BrandItemResponseDTO findBrandItemResponseDTOById(Integer id);

    BrandDetailResponseDTO findBrandDetailResponseDTOById(Integer id);

    boolean deleteBrandById(Integer brandId);
}
