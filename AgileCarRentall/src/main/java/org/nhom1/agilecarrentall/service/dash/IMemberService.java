package org.nhom1.agilecarrentall.service.dash;

import com.capstone.app.entity.dto.dashboard.request.MemberRequestDTO;

public interface IMemberService {

	MemberRequestDTO register(MemberRequestDTO memberRequestDTO);
	Double getCurrentWalletBalance();
}
