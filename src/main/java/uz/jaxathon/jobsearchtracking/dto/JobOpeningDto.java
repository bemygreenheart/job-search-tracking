package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobOpeningDto {
    private String title;
    private String description;
    private String companyName;
    private double salary;
    private JobType jobType;
    private ExperienceLevel experienceLevel;
    private OfficeLocation officeLocation;
    private Education education;
    private LocalDateTime postedTime;
    private WorkingFormat workingFormat;
    private List<Skill> requiredSkills;
}
