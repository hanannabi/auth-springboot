package com.example.storyEndPoint.repository;

import com.example.storyEndPoint.entity.UserManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserManagementRepository extends JpaRepository<UserManagementEntity, Long> {
    Optional<UserManagementEntity> findByUsername(String username);
}
