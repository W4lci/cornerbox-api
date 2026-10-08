package com.cornerbox.api.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gym")
@Getter 
@Setter 
@AllArgsConstructor  
@Builder
public class Gym {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "address", nullable = false)
    private String address;

    @Column (name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    @PrePersist 
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }



}
