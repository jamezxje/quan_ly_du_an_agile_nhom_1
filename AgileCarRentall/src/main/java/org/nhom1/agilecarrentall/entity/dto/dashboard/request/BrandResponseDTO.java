package org.nhom1.agilecarrentall.entity.dto.dashboard.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.Image;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponseDTO {

    private Integer brandId;
    private String brandLogoUrl;
    private String brandName;
    private String brandDescription;
    private Image brandLogo;

}
