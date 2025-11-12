package com.example.storyEndPoint.entity;

import java.time.Instant;
import java.util.UUID;

public record ProgramNote(
        String id,
        String comment,
        boolean isPinned,
        Instant updatedAt,
        String updatedBy
) {
    public ProgramNote(String comment, boolean isPinned, Instant updatedAt, String updatedBy) {
        this(UUID.randomUUID().toString(), comment, isPinned, updatedAt, updatedBy);
    }
}
