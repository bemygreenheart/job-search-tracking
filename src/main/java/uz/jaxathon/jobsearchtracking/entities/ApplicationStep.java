package uz.jaxathon.jobsearchtracking.entities;

import java.time.LocalDateTime;
import java.util.List;

public class ApplicationStep {
    private Long id;
    private String name;
    private String feedback;
    private String summary;
    private String interviewerName;
    private ApplicationStatus matchingStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Question> questions;
}
