package org.nhom1.agilecarrentall.service.common;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.nhom1.agilecarrentall.entity.dto.front.response.BrandItemResponseDTO;
import org.nhom1.agilecarrentall.service.dash.BrandService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommonDataService {

    @Getter
    private List<BrandItemResponseDTO> brands;

    private final BrandService brandService;

    @PostConstruct
    public void init() {
        brands = brandService.findAllBrandItemResponseDTO();
    }

    public void refreshBrands() {
        brands = brandService.findAllBrandItemResponseDTO();
    }

}
