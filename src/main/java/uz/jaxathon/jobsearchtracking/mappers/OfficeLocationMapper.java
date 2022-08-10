package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.OfficeLocationDto;
import uz.jaxathon.jobsearchtracking.entities.OfficeLocation;

@Mapper
public interface OfficeLocationMapper extends BaseMapper<OfficeLocation, OfficeLocationDto>{
}
