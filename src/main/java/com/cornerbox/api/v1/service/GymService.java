package com.cornerbox.api.v1.service;

import org.springframework.stereotype.Service;

import com.cornerbox.api.v1.dto.GymCreateRequest;
import com.cornerbox.api.v1.dto.GymResponse;
import com.cornerbox.api.v1.models.Gym;
import com.cornerbox.api.v1.repository.GymRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  
public class GymService {
    
    private final GymRepository gymRepository;

    @Transactional
    public GymResponse createGym(GymCreateRequest request) {
        if (gymRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("This email is already in use. Please use a different email.");
        }

        Gym gym = Gym.builder()
                .name(request.name())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .capacity(request.capacity())
                .build();


        // Save data
        Gym savedGym = gymRepository.save(gym);

        return mapToResponse(savedGym);
    }

    @Transactional(readOnly = true)
    public GymResponse getAllGyms (){
        return gymRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No gyms found"));
    }

    @Transactional(readOnly = true)
    public GymResponse getGymById(Long id) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gym not found with id: " + id));
        return mapToResponse(gym);
    }


    private GymResponse mapToResponse(Gym gym) {
        return new GymResponse(
                gym.getId(),
                gym.getName(),
                gym.getAddress(),
                gym.getPhoneNumber(),
                gym.getEmail(),
                gym.getCapacity(),
                gym.getCreatedAt()
        );
    }


}
