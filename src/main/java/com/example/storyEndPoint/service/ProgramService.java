package com.example.storyEndPoint.service;

import com.example.storyEndPoint.dto.request.PogramRequest;
import com.example.storyEndPoint.dto.response.ProgramResponse;
import com.example.storyEndPoint.entity.ProgramEntity;
import com.example.storyEndPoint.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.storyEndPoint.mapper.ProgramMapper.*;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public ProgramResponse add(PogramRequest request) {
        ProgramEntity entity = dtoToEntity(request);
        ProgramEntity programEntity = programRepository.save(entity);
        return toDto(programEntity);
    }
}
