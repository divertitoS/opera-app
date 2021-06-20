package com.dev.opera.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "performance_sessions")
public class PerformanceSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Performance performance;
    @ManyToOne
    private Stage stage;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getperformance() {
        return performance;
    }

    public void setperformance(Performance performance) {
        this.performance = performance;
    }

    public Stage getstageHall() {
        return stage;
    }

    public void setstageHall(Stage stage) {
        this.stage = stage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "performanceSession{"
                + "id=" + id
                + ", performance=" + performance
                + ", stageHall=" + stage
                + ", showTime=" + showTime + '}';
    }
}
