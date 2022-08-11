package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;

import java.time.LocalDateTime;

@Mapper
public abstract class ApplicationStepMapper implements BaseMapper<ApplicationStep, ApplicationStepDto> {
    @AfterMapping
    protected ApplicationStep setDefaultValuesToNewEntity(@MappingTarget ApplicationStep entity){
        if(entity.getStartTime() == null){
            entity.setStartTime(LocalDateTime.now());
        }
        return entity;
    }
}
