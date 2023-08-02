package com.omar.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

//    @CreatedDate
    @Column(name= "creationDate", nullable = false)
    private Instant creationDate;


//    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

    @PrePersist
    void prePersist(){
        creationDate = Instant.now();
    }
    @PreUpdate

    void preUpdate(){
        lastModifiedDate = Instant.now();
    }


}
