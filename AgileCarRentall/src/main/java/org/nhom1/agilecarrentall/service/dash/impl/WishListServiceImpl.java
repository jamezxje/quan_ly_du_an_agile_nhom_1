package org.nhom1.agilecarrentall.service.dash.impl;

import org.nhom1.agilecarrentall.entity.Car;
import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.WishItem;
import org.nhom1.agilecarrentall.entity.WishItemId;
import org.nhom1.agilecarrentall.entity.dto.front.response.WishItemResponseDTO;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.nhom1.agilecarrentall.repository.WishItemRepo;
import org.nhom1.agilecarrentall.service.dash.WishItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishItemService {

    private final MemberRepo memberRepo;
    private final WishItemRepo wishItemRepo;

    private Member member;

    public boolean isMemberPresent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            member = memberRepo.findByUserName(authentication.getName());
            return true;
        }
        member = null;
        return false;
    }

    @Override
    public List<WishItemResponseDTO> findAllWishItemResponseDTO() {
        if (isMemberPresent()) {
            Integer memberId = member.getMemberId();
            return wishItemRepo.findAllWishItemResponseDTO(memberId);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveWishItem(Car car) {

        if (!isMemberPresent()) {
            return false;
        }

        WishItem wishItem = new WishItem();
        WishItemId wishItemId = new WishItemId(member.getMemberId(), car.getCarId());
        wishItem.setWishItemId(wishItemId);
//        wishItem.setCar(car);
//        wishItem.setMember(member);

        WishItem saved = wishItemRepo.save(wishItem);
        return saved.getWishItemId() != null;
//        return (saved.getCar() != null);
    }

    @Override
    public boolean deleteWishItemByMemberIdAndCarId(Integer carId) {

        if (!isMemberPresent()) {
            return false;
        }

        WishItemId wishItemId = new WishItemId(member.getMemberId(), carId);

        wishItemRepo.deleteById(wishItemId);

        return wishItemRepo.existsWishItemByWishItemId(wishItemId);
    }

    @Override
    public boolean existsByWishItemId(WishItemId wishItemId) {
        return wishItemRepo.existsWishItemByWishItemId(wishItemId);
    }
}
