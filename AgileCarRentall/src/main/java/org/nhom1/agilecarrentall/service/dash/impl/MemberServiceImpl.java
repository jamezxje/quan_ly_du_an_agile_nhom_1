package org.nhom1.agilecarrentall.service.dash.impl;

import org.nhom1.agilecarrentall.entity.Image;
import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.MemberRequestDTO;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.nhom1.agilecarrentall.service.common.FilesStorageService;
import lombok.RequiredArgsConstructor;
import org.nhom1.agilecarrentall.service.dash.MemberService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepo memberRepo;
    private final FilesStorageService filesStorageService;

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
    public void editMember(MemberRequestDTO request) {
        if (isMemberPresent()) {
            if (!member.getEmail().equals(request.getEmail())) {
                member.setIsVerified(false);
            }
            request.updateEntity(member);
            if (request.getDeleteFeatureImage() != null && request.getDeleteFeatureImage()) {
                filesStorageService.delete(member.getFeatureImage());
                member.setFeatureImage(null);
            }
            if (request.getFeatureImage() != null && !request.getFeatureImage().isEmpty()) {
                Image featureImage = filesStorageService.save(request.getFeatureImage());
                member.setFeatureImage(featureImage);
            }
            memberRepo.save(member);
        } else {
            throw new RuntimeException("Member not logged");
        }
    }

    @Override
    public MemberRequestDTO findMemberRequestDTO() {
        if (isMemberPresent()) {
            return MemberRequestDTO.toDTO(member);
        }
        throw new RuntimeException("Can not find member");
    }

    @Override
    public double getMemberBalance(Integer id) {
        return memberRepo.findById(id).get().getWalletBalance();
    }
}
