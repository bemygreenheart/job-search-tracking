package uz.jaxathon.jobsearchtracking.entities;

import java.time.LocalDateTime;

public class JobApplication {
    private Long id;
    private String email;
    private String phone;
    private LocalDateTime submittedTime;
    private String resumeVersion;
    private ApplicationStatus applicationStatus;
}
