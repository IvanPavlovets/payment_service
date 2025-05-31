package com.example.paymentservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {
    private String number;
    private BigDecimal balance; // если с деньгами, то BigDecimal, копейки и т.д
    private Long customerId; // id владельца банковского аккаунта
    private String currency;
}
