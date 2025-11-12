package com.example.storyEndPoint.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class ProgramNoteRequest {

    private String noteText;
    private @JsonProperty("isPinned") boolean isPinned;

    public ProgramNoteRequest() {
    }

    public String noteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }
}
