package org.nhom1.agilecarrentall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.nhom1.agilecarrentall.entity.type.TransactionStatus;
import org.nhom1.agilecarrentall.entity.type.TransactionType;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "deposit_request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer depositRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "request_time", nullable = false)
    private LocalDateTime requestTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Column(name = "note")
    private String note;
}
