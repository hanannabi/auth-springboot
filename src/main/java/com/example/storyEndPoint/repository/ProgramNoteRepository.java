package com.example.storyEndPoint.repository;

import com.example.storyEndPoint.entity.ProgramEntity;
import com.example.storyEndPoint.entity.ProgramNote;
import com.example.storyEndPoint.entity.ProgramNoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramNoteRepository extends JpaRepository<ProgramNoteEntity, Long> {
    Optional<ProgramNoteEntity> findByPageId(Long pageId);
}
