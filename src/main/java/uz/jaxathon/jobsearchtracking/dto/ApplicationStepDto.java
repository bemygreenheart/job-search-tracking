package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStatus;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ApplicationStepDto {
    @NotBlank
    private String name;
    @NotBlank
    private String feedback;
    @NotBlank
    private String summary;
    private String interviewerName;
    @NotNull(message = "Application step status can not be null")
    private ApplicationStatus matchingStatus = ApplicationStatus.OTHER;

    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;
}
