package com.example.storyEndPoint.mapper;

import com.example.storyEndPoint.dto.request.PogramRequest;
import com.example.storyEndPoint.dto.response.ProgramResponse;
import com.example.storyEndPoint.entity.ProgramEntity;

public class ProgramMapper {
    public static ProgramEntity dtoToEntity(PogramRequest request) {
        return new ProgramEntity(
                request.getName());
    }

    public static ProgramResponse toDto(ProgramEntity programEntity) {
        return new ProgramResponse(programEntity.getPageId(),
                programEntity.getName());
    }
}
