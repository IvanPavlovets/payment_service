package com.example.paymentservice.model.entity;

import com.example.paymentservice.model.enums.PaymentTransactionStatus;
import com.example.paymentservice.model.enums.converter.PaymentTransactionStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 1. Не можем обьявить поле paymentTransactionStatus,
 * бд про это не знает, нужен конвертер,
 * конвертирует enum в строку.
 * 2. В @Convert обьявляем что за конвертер нужно использовать
 */
@Entity
@Table(name = "payment_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity {
    private BigDecimal amount;
    private String currency;

    @Convert(converter = PaymentTransactionStatusConverter.class)
    private PaymentTransactionStatus status;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "destinationBankAccountId")
    private BankAccount destinationBankAccount;

    /**
     * cascade - как операции с основной сущности будут каскодироваться на связаные.
     * сохранится PaymentTransaction и ее дочерние сущности refunds.
     */
    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;
}
