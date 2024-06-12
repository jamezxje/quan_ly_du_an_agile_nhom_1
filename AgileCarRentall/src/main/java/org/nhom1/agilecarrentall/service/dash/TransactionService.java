package org.nhom1.agilecarrentall.service.dash;

import org.nhom1.agilecarrentall.entity.Member;
import org.nhom1.agilecarrentall.entity.Transaction;
import org.nhom1.agilecarrentall.entity.dto.filter.TransactionFilterRequest;
import org.nhom1.agilecarrentall.entity.dto.pagination.PaginationResponse;
import org.nhom1.agilecarrentall.entity.type.TransactionStatus;
import org.nhom1.agilecarrentall.entity.type.TransactionType;

import java.util.List;

public interface TransactionService {
    PaginationResponse<List<Transaction>> findByFilter(TransactionFilterRequest request);
    String changeDepositStatus(Integer id, TransactionStatus status);
    boolean createRequestTransaction(Member member, double amount, TransactionType type);
}
