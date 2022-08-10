package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.JobOpeningDto;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;

@Mapper
public interface JobOpeningMapper extends BaseMapper<JobOpening, JobOpeningDto>{

}
