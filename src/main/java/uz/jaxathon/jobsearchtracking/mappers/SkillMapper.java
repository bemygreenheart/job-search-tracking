package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.SkillDto;
import uz.jaxathon.jobsearchtracking.entities.Skill;

@Mapper
public interface SkillMapper extends BaseMapper<Skill, SkillDto>{
}
