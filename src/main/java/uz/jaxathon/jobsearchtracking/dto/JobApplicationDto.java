package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class JobApplicationDto {

    @NotBlank(message = "Email can not be blank")
    private String email;
    @NotBlank(message = "Phone can not be blank")
    private String phone;
    @NotNull(message = "Submission time can not be null")
    private LocalDateTime submittedTime = LocalDateTime.now();
    private String resumeVersion;
    private ApplicationStatus applicationStatus;
}
