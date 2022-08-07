package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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
