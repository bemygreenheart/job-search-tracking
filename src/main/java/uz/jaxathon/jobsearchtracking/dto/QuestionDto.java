package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;

@Data
public class QuestionDto {
    private String content;
    private String given_answer;
    private String actual_answer;
}
