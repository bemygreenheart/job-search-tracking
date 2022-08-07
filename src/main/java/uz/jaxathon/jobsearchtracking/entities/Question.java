package uz.jaxathon.jobsearchtracking.entities;

public class Question {
    private Long id;
    private String content;

    // If the given answer can not be represented as a string,
    // {given_answer} and {actual_answer} contain the link to google docs with the answer
    private String given_answer;
    private String actual_answer;
    private ApplicationStep applicationStep;

}
