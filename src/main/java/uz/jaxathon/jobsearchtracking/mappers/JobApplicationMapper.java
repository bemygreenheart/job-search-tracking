package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.jaxathon.jobsearchtracking.dto.JobApplicationDto;
import uz.jaxathon.jobsearchtracking.entities.*;

@Mapper
public abstract class JobApplicationMapper implements BaseMapper<JobApplication, JobApplicationDto> {

    @AfterMapping
    protected JobApplication setDefaultValuesToNewEntity(@MappingTarget JobApplication entity){
        if(entity.getApplicationStatus() == null){
            entity.setApplicationStatus(ApplicationStatus.SUBMITTED);
        }
        return entity;
    }
}
