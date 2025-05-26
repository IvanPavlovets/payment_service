package com.example.paymentservice.model.enums.converter;

import com.example.paymentservice.model.enums.PaymentTransactionStatus;
import com.example.paymentservice.model.enums.RefundStatus;
import jakarta.persistence.AttributeConverter;

public class RefundStatusConverter implements AttributeConverter<RefundStatus, String> {
    @Override
    public String convertToDatabaseColumn(RefundStatus attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public RefundStatus convertToEntityAttribute(String dbData) {
        return dbData == null ? null : RefundStatus.fromString(dbData);
    }
}
