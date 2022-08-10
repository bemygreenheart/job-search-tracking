package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.JobApplicationDto;
import uz.jaxathon.jobsearchtracking.entities.JobApplication;

@Mapper
public interface JobApplicationMapper extends BaseMapper<JobApplication, JobApplicationDto> {
}
