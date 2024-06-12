package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.dto.dashboard.request.MemberRequestDTO;
import org.nhom1.agilecarrentall.entity.dto.dashboard.response.MemberResponseDTO;
import org.nhom1.agilecarrentall.entity.type.MemberRole;
import org.springframework.data.domain.Page;

public interface IAdminService {

	MemberResponseDTO getMemberByID(Integer id);

	Page<MemberResponseDTO> getAllMember(Integer index, Integer size);

	Page<MemberResponseDTO> getAllMemberByRole(MemberRole role, Integer index, Integer size);

	MemberRequestDTO addNewMember(MemberRequestDTO memberRequestDTO);

	MemberRequestDTO updateMember(MemberRequestDTO memberRequestDTO);

	MemberResponseDTO changeMemberActiveStatus(Integer id, Boolean status);

	MemberResponseDTO getMemberFromContext();

	MemberResponseDTO deleteMember(Integer id);

}
