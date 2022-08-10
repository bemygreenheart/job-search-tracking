package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Recruiter {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CommunicationType mainCommunicationType;
    private String email;
    private String addressingName;

    public Recruiter() {
    }

    public Recruiter(String name, CommunicationType mainCommunicationType, String email, String addressingName) {
        this.name = name;
        this.mainCommunicationType = mainCommunicationType;
        this.email = email;
        this.addressingName = addressingName;
    }
}
