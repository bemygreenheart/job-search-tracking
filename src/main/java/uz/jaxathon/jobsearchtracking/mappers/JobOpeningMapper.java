package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.jaxathon.jobsearchtracking.dto.JobOpeningDto;
import uz.jaxathon.jobsearchtracking.entities.*;

import java.time.LocalDateTime;

@Mapper
public abstract class JobOpeningMapper implements BaseMapper<JobOpening, JobOpeningDto>{

    @AfterMapping
    protected JobOpening setDefaultValuesToNewEntity( @MappingTarget JobOpening entity){
        if(entity.getJobType() == null){
            entity.setJobType(JobType.UNKNOWN);
        }
        if(entity.getExperienceLevel() == null){
            entity.setExperienceLevel(ExperienceLevel.NO_EXPERIENCE);
        }
        if(entity.getEducation() == null){
            entity.setEducation(Education.NONE);
        }
        if(entity.getWorkingFormat() == null){
            entity.setWorkingFormat(WorkingFormat.UNKNOWN);
        }
        if(entity.getPostedTime() == null){
            entity.setPostedTime(LocalDateTime.now());
        }
        return entity;
    }
}
