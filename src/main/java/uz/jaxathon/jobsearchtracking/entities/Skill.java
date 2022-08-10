package uz.jaxathon.jobsearchtracking.entities;


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
    @ManyToOne
    private JobOpening jobOpening;
}
