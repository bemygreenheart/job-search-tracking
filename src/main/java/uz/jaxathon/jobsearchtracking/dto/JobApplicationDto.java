package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStatus;

import java.time.LocalDateTime;

@Data
public class JobApplicationDto {

    private String email;
    private String phone;
    private LocalDateTime submittedTime;
    private String resumeVersion;
    private ApplicationStatus applicationStatus;
}
