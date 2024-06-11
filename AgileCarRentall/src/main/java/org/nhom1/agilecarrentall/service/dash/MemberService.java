package org.nhom1.agilecarrentall.service.dash;

import com.capstone.app.entity.dto.dashboard.request.MemberRequestDTO;

;

public interface MemberService {
    void editMember(MemberRequestDTO request);
    MemberRequestDTO findMemberRequestDTO();
    double getMemberBalance(Integer id);
}
