package uz.jaxathon.jobsearchtracking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Data
@Entity
public class JobApplication {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String phone;
    private LocalDateTime submittedTime;
    private String resumeVersion;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @OneToMany(mappedBy = "jobApplication")
    private List<ApplicationStep> applicationSteps = new ArrayList<>();

    @OneToOne
    private JobOpening jobOpening;

    @JsonIgnore
    @Version
    private int version;

    public JobApplication() {
    }

    public JobApplication(String email, String phone, LocalDateTime submittedTime,
                          String resumeVersion, ApplicationStatus applicationStatus) {
        this.email = email;
        this.phone = phone;
        this.submittedTime = submittedTime;
        this.resumeVersion = resumeVersion;
        this.applicationStatus = applicationStatus;
    }

    @Transactional
    public void addApplicationStep(ApplicationStep step){
        this.applicationSteps.add(step);
        updateStatusFromNewStep(step);
        step.setJobApplication(this);
    }

    private void updateStatusFromNewStep(ApplicationStep step){
        ApplicationStatus stepStatus = step.getMatchingStatus();
        EnumSet stepStatusesWithoutEffectOfApplicationStatus = EnumSet.of(ApplicationStatus.OTHER, ApplicationStatus.SUBMITTED);
        if(!stepStatusesWithoutEffectOfApplicationStatus.contains(stepStatus)){
            this.setApplicationStatus(stepStatus);
        }
    }
}
