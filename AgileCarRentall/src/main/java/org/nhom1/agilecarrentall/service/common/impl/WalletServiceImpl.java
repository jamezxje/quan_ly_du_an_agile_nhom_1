package org.nhom1.agilecarrentall.service.common.impl;

import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.SystemOption;
import org.nhom1.agilecarrentall.entity.Transaction;
import org.nhom1.agilecarrentall.entity.type.TransactionStatus;
import org.nhom1.agilecarrentall.entity.type.TransactionType;
import org.nhom1.agilecarrentall.repository.MemberRepo;
import org.nhom1.agilecarrentall.repository.SystemOptionRepo;
import org.nhom1.agilecarrentall.repository.TransactionRepo;
import org.nhom1.agilecarrentall.service.common.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final MemberRepo memberRepo;
    private final TransactionRepo transactionRepo;
    private final SystemOptionRepo systemOptionRepo;

    @Override
    public void memberToAdmin(Member member, double amount, String note) {

        if (amount == (0)) {
            return;
        }

        member.setWalletBalance(member.getWalletBalance() - amount);

        Transaction memberTrans = Transaction.builder()
                .amount(amount)
                .status(TransactionStatus.AUTO)
                .member(member)
                .type(TransactionType.AUTO_OUT)
                .requestTime(LocalDateTime.now())
                .note(note)
                .build();

        SystemOption systemOption = systemOptionRepo.findByOptionkey("system_balance");
        systemOption.setOptionValue((Double.parseDouble(systemOption.getOptionValue()) + memberTrans.getAmount()) + "");
        systemOptionRepo.save(systemOption);

        memberRepo.save(member);
        transactionRepo.save(memberTrans);
    }

    @Override
    public void memberToMember(Member from, Member to, double amount, String note) {
        from.setWalletBalance(from.getWalletBalance() - amount);
        to.setWalletBalance(to.getWalletBalance() + amount);

        Transaction fromTrans = Transaction.builder()
                .amount(amount)
                .status(TransactionStatus.AUTO)
                .member(from)
                .type(TransactionType.AUTO_OUT)
                .requestTime(LocalDateTime.now())
                .note(note)
                .build();

        Transaction toTrans = Transaction.builder()
                .amount(amount)
                .status(TransactionStatus.AUTO)
                .member(to)
                .type(TransactionType.AUTO_IN)
                .requestTime(LocalDateTime.now())
                .note(note)
                .build();

        memberRepo.saveAll(List.of(from, to));
        transactionRepo.saveAll(List.of(fromTrans, toTrans));
    }
}
