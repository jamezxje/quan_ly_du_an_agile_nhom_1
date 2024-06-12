package org.nhom1.agilecarrentall.service.dash.impl;

import org.nhom1.agilecarrentall.config.auth.UserDetailsCustom;
import org.nhom1.agilecarrentall.entity.dto.dashboard.request.MemberRequestDTO;
import org.nhom1.agilecarrentall.exception.NotFoundException;
import org.nhom1.agilecarrentall.mapper.MemberMapper;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.nhom1.agilecarrentall.service.dash.IMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements IMemberService {

	private final MemberRepo memberRepo;
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public MemberRequestDTO register(MemberRequestDTO memberRequestDTO) {
		memberRequestDTO.setCreatedDate(LocalDateTime.now());
		memberRequestDTO.setLastModifiedDate(LocalDateTime.now());
		memberRequestDTO.setWalletBalance(.0);
		memberRequestDTO.setIsActive(true);
		memberRequestDTO.setPassword(passwordEncoder.encode(memberRequestDTO.getPassword()));
		memberRepo.save(memberMapper.requestDTOToEntity(memberRequestDTO));
		return memberRequestDTO;
	}

	@Override
	public Double getCurrentWalletBalance() {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) return 0.0;
		UserDetailsCustom userDetails = (UserDetailsCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return memberRepo.findById(userDetails.getMember().getMemberId()).orElseThrow(NotFoundException::new).getWalletBalance();
	}
}
