package org.nhom1.agilecarrentall.entity.dto.dashboard.response;

import lombok.Getter;
import lombok.Setter;
import org.nhom1.agilecarrentall.entity.Image;
import org.nhom1.agilecarrentall.entity.type.MemberRole;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class MemberResponseDTO {

	private Integer memberId;

	private Image featureImage;

	private String nationalId;

	private String fullName;

	private MemberRole role;

	private Double walletBalance;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	private String email;

	private String phoneNumber;


	private String address;


	private String userName;

	private String password;

	private Boolean isVerified;

	private Boolean isActive;


	private String createdDate;

	private String lastModifiedDate;
}
