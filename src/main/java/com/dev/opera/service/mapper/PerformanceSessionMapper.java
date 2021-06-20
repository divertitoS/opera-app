package com.dev.opera.service.mapper;

import com.dev.opera.dto.request.PerformanceSessionRequestDto;
import com.dev.opera.dto.response.PerformanceSessionResponseDto;
import com.dev.opera.model.PerformanceSession;
import com.dev.opera.service.PerformanceService;
import com.dev.opera.service.StageService;
import com.dev.opera.util.DateTimePatternUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapper
        implements RequestDtoMapper<PerformanceSessionRequestDto, PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService stageService;
    private final PerformanceService performanceService;

    public PerformanceSessionMapper(StageService stageService,
                                    PerformanceService performanceService) {
        this.stageService = stageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setperformance(performanceService.get(dto.getPerformanceId()));
        performanceSession.setstageHall(stageService.get(dto.getStageId()));
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performanceSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setperformanceSessionId(performanceSession.getId());
        responseDto.setstageHallId(performanceSession.getstageHall().getId());
        responseDto.setperformanceId(performanceSession.getperformance().getId());
        responseDto.setperformanceTitle(performanceSession.getperformance().getTitle());
        responseDto.setShowTime(performanceSession.getShowTime().format(formatter));
        return responseDto;
    }
}
