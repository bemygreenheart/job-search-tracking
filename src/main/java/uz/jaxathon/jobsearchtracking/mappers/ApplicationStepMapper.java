package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;

@Mapper
public interface ApplicationStepMapper extends BaseMapper<ApplicationStep, ApplicationStepDto> {
}
