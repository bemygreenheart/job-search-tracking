package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QuestionDto {
    @NotBlank
    private String content;
    @NotBlank
    private String given_answer;
    @NotBlank
    private String actual_answer;
}
