package uz.jaxathon.jobsearchtracking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
//@Entity
public class JobOpening {
//    @Id
    private Long id;
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

    public double getHourlySalary(){
        return salary / Constants.NUMBER_OF_HOURS_A_YEAR;
    }

    public void setSalaryWithPerHourRate(double perHourRate){
        this.salary = perHourRate * Constants.NUMBER_OF_HOURS_A_YEAR;
    }
}
