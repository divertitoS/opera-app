package com.dev.opera.dto.response;

public class PerformanceSessionResponseDto {
    private Long performanceSessionId;
    private Long performanceId;
    private String performanceTitle;
    private Long stageHallId;
    private String showTime;

    public Long getperformanceSessionId() {
        return performanceSessionId;
    }

    public void setperformanceSessionId(Long performanceSessionId) {
        this.performanceSessionId = performanceSessionId;
    }

    public Long getperformanceId() {
        return performanceId;
    }

    public void setperformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public String getperformanceTitle() {
        return performanceTitle;
    }

    public void setperformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public Long getstageHallId() {
        return stageHallId;
    }

    public void setstageHallId(Long stageHallId) {
        this.stageHallId = stageHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
