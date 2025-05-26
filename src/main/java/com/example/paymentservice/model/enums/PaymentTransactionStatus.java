package com.example.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum PaymentTransactionStatus {
    PROCESSING,
    SUCCESS,
    FAILED;

    /**
     * Из строки конвертация в Enum.
     * Проходимся по всем возможным статусам
     * и сравниваем их с переданной строкой,
     * если они совпадают то возвращаем этот статус
     * @return PaymentTransactionStatus
     */
    public static PaymentTransactionStatus fromString(String status) {
        for (PaymentTransactionStatus paymentTransactionStatus : PaymentTransactionStatus.values()) {
            if (paymentTransactionStatus.toString().equalsIgnoreCase(status)) {
                return paymentTransactionStatus;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentTransactionStatus: " + status);
    }
}
