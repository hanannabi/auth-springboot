package com.example.storyEndPoint.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "program_notes")
public class ProgramNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "page_id")
    private Long pageId;

    @Type(JsonType.class)
    @Column(name = "program_notes", columnDefinition = "json")
    private List<ProgramNote> notes;

    public ProgramNoteEntity(Long id, Long pageId, List<ProgramNote> notes) {
        this.id = id;
        this.pageId = pageId;
        this.notes = notes;
    }

    public ProgramNoteEntity(String noteText, boolean pinned) {
    }

    public ProgramNoteEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public List<ProgramNote> getNotes() {
        return notes;
    }

    public void setNotes(List<ProgramNote> notes) {
        this.notes = notes;
    }
}
