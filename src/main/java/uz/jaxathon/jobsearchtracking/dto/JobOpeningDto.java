package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobOpeningDto {
    @NotBlank(message = "Job opening title can not be blank")
    private String title;
    private String description;
    @NotBlank(message = "Company name can not be blank")
    private String companyName;
    private double salary;
    private JobType jobType = JobType.UNKNOWN;
    private ExperienceLevel experienceLevel = ExperienceLevel.NO_EXPERIENCE;
    private Education education = Education.NONE;
    private LocalDateTime postedTime = LocalDateTime.now();
    private WorkingFormat workingFormat = WorkingFormat.UNKNOWN;
}
