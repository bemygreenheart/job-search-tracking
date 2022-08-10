package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class JobOpening {
    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String companyName;
    private double salary;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;
    @OneToOne
    private OfficeLocation officeLocation;
    @Enumerated(EnumType.STRING)
    private Education education;
    private LocalDateTime postedTime;
    @Enumerated(EnumType.STRING)
    private WorkingFormat workingFormat;
    @OneToMany(mappedBy = "jobOpening")
    private List<Skill> requiredSkills;
    @OneToOne
    private Recruiter recruiter;
    @OneToOne(mappedBy = "jobOpening")
    private JobApplication jobApplication;

    public JobOpening() {
    }

    public JobOpening(String title, String description, String companyName, double salary,
                      JobType jobType, ExperienceLevel experienceLevel, OfficeLocation officeLocation,
                      Education education, LocalDateTime postedTime, WorkingFormat workingFormat) {
        this.title = title;
        this.description = description;
        this.companyName = companyName;
        this.salary = salary;
        this.jobType = jobType;
        this.experienceLevel = experienceLevel;
        this.officeLocation = officeLocation;
        this.education = education;
        this.postedTime = postedTime;
        this.workingFormat = workingFormat;
    }

    public double getHourlySalary(){
        return salary / Constants.NUMBER_OF_HOURS_A_YEAR;
    }

    public void setSalaryWithPerHourRate(double perHourRate){
        this.salary = perHourRate * Constants.NUMBER_OF_HOURS_A_YEAR;
    }
}
