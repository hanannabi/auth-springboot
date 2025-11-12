package com.example.storyEndPoint.repository;

import com.example.storyEndPoint.entity.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {
    Optional<ProgramEntity> findByPageId(Long pageId);
}
