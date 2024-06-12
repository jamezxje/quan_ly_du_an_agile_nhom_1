package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.Car;
import org.nhom1.agilecarrentall.entity.WishItemId;
import org.nhom1.agilecarrentall.entity.dto.front.response.WishItemResponseDTO;

import java.util.List;

public interface WishItemService {
    List<WishItemResponseDTO> findAllWishItemResponseDTO();

    boolean saveWishItem(Car car);

    boolean deleteWishItemByMemberIdAndCarId(Integer carId);

    boolean existsByWishItemId(WishItemId wishItemId);

}
