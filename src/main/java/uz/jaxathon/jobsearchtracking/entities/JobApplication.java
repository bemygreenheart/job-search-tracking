package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private List<ApplicationStep> applicationSteps;

    @OneToOne
    private JobOpening jobOpening;


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
}
