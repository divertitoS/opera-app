package com.dev.opera.service.mapper;

import com.dev.opera.dto.request.PerformanceRequestDto;
import com.dev.opera.dto.response.PerformanceResponseDto;
import com.dev.opera.model.Performance;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapper implements RequestDtoMapper<PerformanceRequestDto, Performance>,
        ResponseDtoMapper<PerformanceResponseDto, Performance> {
    @Override
    public Performance mapToModel(PerformanceRequestDto dto) {
        Performance performance = new Performance();
        performance.setTitle(dto.getPerformanceTitle());
        performance.setDescription(dto.getPerformanceDescription());
        return performance;
    }

    @Override
    public PerformanceResponseDto mapToDto(Performance performance) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setperformanceId(performance.getId());
        responseDto.setperformanceTitle(performance.getTitle());
        responseDto.setperformanceDescription(performance.getDescription());
        return responseDto;
    }
}
