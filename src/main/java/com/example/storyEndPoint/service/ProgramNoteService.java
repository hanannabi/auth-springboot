package com.example.storyEndPoint.service;

import com.example.storyEndPoint.dto.request.ProgramNoteRequest;
import com.example.storyEndPoint.dto.response.ProgramNoteResponse;
import com.example.storyEndPoint.entity.ProgramNote;
import com.example.storyEndPoint.entity.ProgramNoteEntity;
import com.example.storyEndPoint.repository.ProgramNoteRepository;
import com.example.storyEndPoint.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramNoteService {

    private final ProgramNoteRepository programNoteRepository;

    private final ProgramRepository programRepository;

    public ProgramNoteResponse addNote(ProgramNoteRequest programNoteRequest, Long pageId) {
            //This ensures you’re adding notes only to an existing program page.
        System.out.println(programNoteRequest);
        programRepository.findByPageId(pageId)
                .orElseThrow(() -> new RuntimeException("Program not found"));
        //Tries to find an existing ProgramNoteEntity by pageId
        //If not found → creates a new entity and initializes notes as an empty list
        //✅ This means every program page has its own note collection.
        ProgramNoteEntity noteEntity = programNoteRepository.findByPageId(pageId)
                .orElseGet(() -> {
                    ProgramNoteEntity programNoteEntity = new ProgramNoteEntity();
                    programNoteEntity.setPageId(pageId);
                    programNoteEntity.setNotes(new ArrayList<>());
                    return programNoteEntity;
                });

        ProgramNote note = new ProgramNote(
                programNoteRequest.noteText(),
                programNoteRequest.isPinned(),
                Instant.now(),
                "Alice");
        System.out.println("Incoming isPinned: " + programNoteRequest.isPinned());
        noteEntity.getNotes().add(note);
        programNoteRepository.save(noteEntity);

        return new ProgramNoteResponse(note.id(),
                note.comment(),
                note.isPinned(),
                note.updatedAt(),
                note.updatedBy());
    }


    public List<ProgramNoteResponse> getAllProgramNotes(Long pageId) {
        ProgramNoteEntity programNoteEntity = programNoteRepository.findByPageId(pageId)
                .orElseThrow(() -> new RuntimeException("No notes found for this page"));

        List<ProgramNote> notes = programNoteEntity.getNotes();

        notes.sort(Comparator.comparing(ProgramNote::isPinned).reversed()
                .thenComparing(ProgramNote::updatedAt));
        return notes.stream()
                .map(note -> new ProgramNoteResponse(
                        note.id(),
                        note.comment(),
                        note.isPinned(),
                        note.updatedAt(),
                        note.updatedBy()
                ))
                .toList();
    }
}
