package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.RecruiterDto;
import uz.jaxathon.jobsearchtracking.entities.Recruiter;

@Mapper
public interface RecruiterMapper extends BaseMapper<Recruiter, RecruiterDto>{
}
