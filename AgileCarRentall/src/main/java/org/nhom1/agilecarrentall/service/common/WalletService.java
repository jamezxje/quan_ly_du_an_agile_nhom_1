package org.nhom1.agilecarrentall.service.common;

import com.capstone.app.entity.Member;

public interface WalletService {
    void memberToAdmin(Member member, double amount, String note);
    void memberToMember(Member from, Member to, double amount, String note);
}
