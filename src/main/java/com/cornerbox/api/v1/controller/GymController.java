package com.cornerbox.api.v1.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cornerbox.api.v1.dto.GymCreateRequest;
import com.cornerbox.api.v1.dto.GymResponse;
import com.cornerbox.api.v1.service.GymService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/gym")
@RequiredArgsConstructor
public class GymController {

    private final GymService gymService;

    @PostMapping
    public ResponseEntity<GymResponse> createGym(@RequestBody @Valid GymCreateRequest request) {
        GymResponse response = gymService.createGym(request);
        
        //Location 
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }


    @GetMapping 
    public ResponseEntity<GymResponse> getAllGyms() {
        return ResponseEntity.ok(gymService.getAllGyms());
    }


    @GetMapping("/{id}")
    public ResponseEntity<GymResponse> getGymById(@PathVariable Long id) {    
        return ResponseEntity.ok(gymService.getGymById(id));
    }
}
