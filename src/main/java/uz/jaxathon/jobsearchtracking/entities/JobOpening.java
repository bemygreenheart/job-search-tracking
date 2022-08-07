package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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

    public double getHourlySalary(){
        return salary / Constants.NUMBER_OF_HOURS_A_YEAR;
    }

    public void setSalaryWithPerHourRate(double perHourRate){
        this.salary = perHourRate * Constants.NUMBER_OF_HOURS_A_YEAR;
    }
}
