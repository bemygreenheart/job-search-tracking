package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;
import uz.jaxathon.jobsearchtracking.entities.CommunicationType;

@Data
public class RecruiterDto {
    private String name;
    private CommunicationType mainCommunicationType;
    private String email;
    private String addressingName;
}
