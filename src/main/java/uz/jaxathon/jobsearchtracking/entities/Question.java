package uz.jaxathon.jobsearchtracking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Question {

    @Id @GeneratedValue
    private Long id;
    private String content;

    // If the given answer can not be represented as a string,
    // {given_answer} and {actual_answer} contain the link to google docs with the answer
    private String given_answer;
    private String actual_answer;
    @ManyToOne
    private ApplicationStep applicationStep;

    public Question() {
    }

    public Question(String content, String given_answer, String actual_answer, ApplicationStep applicationStep) {
        this.content = content;
        this.given_answer = given_answer;
        this.actual_answer = actual_answer;
        this.applicationStep = applicationStep;
    }
}
