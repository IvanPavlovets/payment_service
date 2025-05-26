package com.example.paymentservice.model.enums.converter;

import com.example.paymentservice.model.enums.PaymentTransactionStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * В методах конвертирует PaymentTransactionStatus
 * в String и обратно. Автоматически Hibernate
 * будет вызывать данный конвертер,
 * что бы конвертировать ENUM в строку а после
 * сохранят в БД.
 */
@Converter(autoApply = true)
public class PaymentTransactionStatusConverter implements AttributeConverter<PaymentTransactionStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentTransactionStatus attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public PaymentTransactionStatus convertToEntityAttribute(String dbData) {
        return dbData == null ? null : PaymentTransactionStatus.fromString(dbData);
    }

}
