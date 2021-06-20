package com.dev.opera.dto.response;

public class PerformanceResponseDto {
    private Long performanceId;
    private String performanceTitle;
    private String performanceDescription;

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

    public String getperformanceDescription() {
        return performanceDescription;
    }

    public void setperformanceDescription(String performanceDescription) {
        this.performanceDescription = performanceDescription;
    }
}
