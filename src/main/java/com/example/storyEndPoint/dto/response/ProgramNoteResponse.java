package com.example.storyEndPoint.dto.response;

import com.example.storyEndPoint.entity.ProgramNote;

import java.time.Instant;
import java.util.List;

public class ProgramNoteResponse {

    private String id;
    String comment;
    boolean isPinned;
    Instant updatedAt;
    String updatedBy;

    public ProgramNoteResponse(Long id, List<ProgramNote> programNotes, Long pageId) {
    }

    public ProgramNoteResponse(String id, String comment, boolean pinned, Instant instant, String updatedBy) {

        this.id = id;
        this.comment = comment;
        this.isPinned = pinned;
        this.updatedAt = instant;
        this.updatedBy = updatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
