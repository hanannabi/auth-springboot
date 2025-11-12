package com.example.storyEndPoint.service;

import com.example.storyEndPoint.dto.request.UserManagementRequest;
import com.example.storyEndPoint.dto.response.UserManagementResponse;
import com.example.storyEndPoint.entity.UserManagementEntity;
import com.example.storyEndPoint.repository.UserManagementRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {


    private final UserManagementRepository userManagementRepository;
    private final PasswordEncoder passwordEncoder;

    public UserManagementService(UserManagementRepository userManagementRepository, PasswordEncoder passwordEncoder) {
        this.userManagementRepository = userManagementRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserManagementResponse create(UserManagementRequest request) {
        if (userManagementRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("User Already exists");
        }
        UserManagementEntity userEntity = new UserManagementEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(request.getRole());
        UserManagementEntity saved = userManagementRepository.save(userEntity);
        return new UserManagementResponse(saved.getId(), saved.getUsername(), saved.getRole().name());

    }
}
