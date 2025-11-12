package com.example.storyEndPoint.controller;

import com.example.storyEndPoint.dto.request.ProgramNoteRequest;
import com.example.storyEndPoint.dto.response.ProgramNoteResponse;
import com.example.storyEndPoint.service.ProgramNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramNoteController {

    @Autowired
    private ProgramNoteService programNoteService;

    @PostMapping("/{pageId}/notes/add")
    public ProgramNoteResponse addNotes(@RequestBody ProgramNoteRequest programNoteRequest,
                                        @PathVariable Long pageId) {
        return programNoteService.addNote(programNoteRequest, pageId);
    }

    @GetMapping("/{pageId}/notes")
    public List<ProgramNoteResponse> getAllProgramNotes(@PathVariable Long pageId) {
        return programNoteService.getAllProgramNotes(pageId);
    }
}
