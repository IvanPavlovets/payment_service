package com.example.paymentservice.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {
    private String name;
    private BigDecimal balance; // если с деньгами, то BigDecimal, копейки и т.д
    private Long customerId; // id владельца банковского аккаунта
    private String currency;
}
