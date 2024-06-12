package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.dto.dashboard.request.MemberRequestDTO;

public interface IMemberService {

	MemberRequestDTO register(MemberRequestDTO memberRequestDTO);
	Double getCurrentWalletBalance();
}
