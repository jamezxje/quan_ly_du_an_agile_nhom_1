package org.nhom1.agilecarrentall.entity.type;


import lombok.Getter;
import org.nhom1.agilecarrentall.entity.constants.MessageConstant;

@Getter
public enum TransactionType {
      AUTO_IN(TransactionMode.DEPOSIT, "Auto Deposit")
    , AUTO_OUT(TransactionMode.WITHDRAW, "Auto Withdraw")
    , REQUEST_IN(TransactionMode.DEPOSIT, "Deposit Request")
    , REQUEST_OUT(TransactionMode.WITHDRAW, "Withdraw Request");

    private final TransactionMode mode;
    private final String value;

    TransactionType(TransactionMode mode, String value) {
        this.mode = mode;
        this.value = value;
    }

    public String getMess() {
        return switch (this) {
            case REQUEST_IN -> MessageConstant.DEPOSIT_REQUEST;
            case REQUEST_OUT -> MessageConstant.WITHDRAW_REQUEST;
            default -> "";
        };
    }
}

