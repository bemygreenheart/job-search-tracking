package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStatus;

import java.time.LocalDateTime;

@Data
public class ApplicationStepDto {
    private String name;
    private String feedback;
    private String summary;
    private String interviewerName;
    private ApplicationStatus matchingStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
