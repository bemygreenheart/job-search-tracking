package uz.jaxathon.jobsearchtracking.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OfficeLocationDto {

    @NotBlank(message = "City can not be blank")
    private String city;
    @NotBlank(message = "State can not be blank")
    private String state;
}
