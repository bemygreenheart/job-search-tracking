package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class SkillDto {
    @NotBlank(message = "Skill name can not be blank")
    private String name;
    @Positive(message = "Month can take only positive value")
    private int months;
}
