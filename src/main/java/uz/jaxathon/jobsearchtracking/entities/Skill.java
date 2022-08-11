package uz.jaxathon.jobsearchtracking.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Skill {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int months;

    @OneToOne
    private Skill mainSkill;

    @JsonIgnore
    @ManyToOne
    private JobOpening jobOpening;

    @JsonIgnore
    @Version
    private int version;
}
