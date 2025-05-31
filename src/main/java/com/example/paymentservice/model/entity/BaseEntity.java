package com.example.paymentservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Дата и время создания записи.
     * Можно заполнять автоматически с помощью персист-колбэков или слушателей (e.g. @PrePersist).
     * hibernate автоматически будет проставлять при создании сущности в бд
     */
    @CreationTimestamp
    private LocalDateTime creteAt;

    /**
     * Дата и время последнего обновления записи.
     * Можно обновлять автоматически в @PreUpdate.
     * автоматически будет проставлять при обновлении сущности в бд
     */
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * Поле, используемое JPA для оптимистической блокировки
     * (чтобы избежать конфликтов параллельного обновления).
     * Необязательно, но часто полезно в enterprise-приложениях.
     */
    @Version
    private Long version;
}
