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

    @CreationTimestamp //hibernate автоматически будет проставлять при создании сущности в бд
    private LocalDateTime creteAt;
    @UpdateTimestamp // автоматически будет проставлять при обновлении сущности в бд
    private LocalDateTime updatedAt;
    @Version
    private Long version;
}
