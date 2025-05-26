package com.example.paymentservice.model.entity;

import com.example.paymentservice.model.enums.RefundStatus;
import com.example.paymentservice.model.enums.converter.RefundStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Refund extends BaseEntity {
    private BigDecimal RefundAmount;
    private String reason;

    @Convert(converter = RefundStatusConverter.class)
    private RefundStatus status;

    // ссылка на саму транзакцию возврат которй делаем
    @ManyToOne
    @JoinColumn(name = "paymentTransaction", referencedColumnName = "id")
    private PaymentTransaction paymentTransaction;
}
