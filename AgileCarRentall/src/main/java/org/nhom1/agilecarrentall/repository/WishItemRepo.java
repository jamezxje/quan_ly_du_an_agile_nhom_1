package org.nhom1.agilecarrentall.repository;

import org.nhom1.agilecarrentall.entity.WishItem;
import org.nhom1.agilecarrentall.entity.WishItemId;
import org.nhom1.agilecarrentall.entity.dto.front.response.WishItemResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishItemRepo extends JpaRepository<WishItem, WishItemId> {
    boolean existsWishItemByWishItemId(WishItemId wishItemId);

    //    @Query("SELECT new org.nhom1.agilecarrentall.entity.dto.front.response.WishItemResponseDTO( w.car.carId, w.car.featureImage.imageUrl, w.car.carModel, w.car.numberOfSeats, w.car.carColor, w.car.basePrice, w.car.featureImage.imageAlt,w.car.status) FROM WishItem w WHERE w.member.memberId = :memberId")
    @Query("SELECT new org.nhom1.agilecarrentall.entity.dto.front.response.WishItemResponseDTO( " +
            "c.carId, c.featureImage.imageUrl, c.carModel, c.numberOfSeats, c.carColor, " +
            "c.basePrice, c.featureImage.imageAlt, c.status) " +
            "FROM WishItem w " +
            "JOIN Car c ON c.carId = w.wishItemId.carId " +
            "WHERE w.wishItemId.memberId = :memberId")
    List<WishItemResponseDTO> findAllWishItemResponseDTO(@Param("memberId") Integer memberId);

}
