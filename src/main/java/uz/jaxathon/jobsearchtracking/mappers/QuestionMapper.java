package uz.jaxathon.jobsearchtracking.mappers;

import org.mapstruct.Mapper;
import uz.jaxathon.jobsearchtracking.dto.QuestionDto;
import uz.jaxathon.jobsearchtracking.entities.Question;

@Mapper
public interface QuestionMapper extends BaseMapper<Question, QuestionDto> {
}
