package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.CommunicationType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RecruiterDto {
    @NotBlank
    private String name;
    @NotNull
    private CommunicationType mainCommunicationType = CommunicationType.EMAIL;
    @NotNull
    private String email;
    private String addressingName;
}
