package com.cornerbox.api.v1.repository;

//JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cornerbox.api.v1.models.Gym;

// Optional for handling null values
import java.util.Optional;

@Repository
public interface GymRepository  extends JpaRepository<Gym, Long> {

    
    Optional<Gym> findById(Long id);
    
    Optional<Gym> findByName(String name);

    Optional<Gym> findByEmail(String email);

    boolean existsByEmail(String email);
}
