package org.nhom1.agilecarrentall.config.auth;

import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceCustom implements UserDetailsService {

    private MemberRepo memberRepo;

    public UserDetailsServiceCustom(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepo.findByUserName(username);

        if(member == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        if(member.getIsActive() == false) {

        }
        return new UserDetailsCustom(member);
    }
}
