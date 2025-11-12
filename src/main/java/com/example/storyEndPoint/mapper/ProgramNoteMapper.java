package com.example.storyEndPoint.mapper;

import com.example.storyEndPoint.dto.request.ProgramNoteRequest;
import com.example.storyEndPoint.dto.response.ProgramNoteResponse;
import com.example.storyEndPoint.entity.ProgramNoteEntity;

public class ProgramNoteMapper {
    public static ProgramNoteEntity dtoToEntity(ProgramNoteRequest programNoteRequest) {
        return new ProgramNoteEntity(programNoteRequest.noteText(),
                programNoteRequest.isPinned());
    }

    public static ProgramNoteResponse entityToDto(ProgramNoteEntity entity) {
        return new ProgramNoteResponse(entity.getId(),
                entity.getNotes(),
                entity.getPageId());
    }
}
