package uz.jaxathon.jobsearchtracking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ApplicationStep {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String feedback;
    private String summary;
    private String interviewerName;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus matchingStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JsonIgnore
    private JobApplication jobApplication;
    @OneToMany(mappedBy = "applicationStep")
    private List<Question> questions = new ArrayList<>();


    public ApplicationStep() {
        this.matchingStatus = ApplicationStatus.OTHER;
        this.startTime = LocalDateTime.now();
    }

    public ApplicationStep(String name, String feedback, String summary, String interviewerName,
                           ApplicationStatus matchingStatus, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.feedback = feedback;
        this.summary = summary;
        this.interviewerName = interviewerName;
        this.matchingStatus = matchingStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setJobApplication(JobApplication jobApplication) {
        if(this.jobApplication == null){
            this.jobApplication = jobApplication;
            jobApplication.addApplicationStep(this);
        }
    }
}
