package br.com.ecstech.messenger.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;
}
