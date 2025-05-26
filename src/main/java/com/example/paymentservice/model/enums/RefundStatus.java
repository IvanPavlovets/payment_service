package com.example.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum RefundStatus {
    COMPLETED,
    FAILED;

    /**
     * Из строки конвертация в Enum.
     * Проходимся по всем возможным статусам
     * и сравниваем их с переданной строкой,
     * если они совпадают то возвращаем этот статус
     * @return RefundStatus
     */
    public static RefundStatus fromString(String status) {
        for (RefundStatus refundStatus : RefundStatus.values()) {
            if (refundStatus.toString().equalsIgnoreCase(status)) {
                return refundStatus;
            }
        }
        throw new IllegalArgumentException("Invalid refundStatus: " + status);
    }
}
