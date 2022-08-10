package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.QuestionDto;
import uz.jaxathon.jobsearchtracking.entities.Question;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.QuestionMapper;
import uz.jaxathon.jobsearchtracking.repos.QuestionRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository repository;
    private final QuestionMapper mapper;

    public Page<Question> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public Question create(QuestionDto dto){
        Question question = mapper.mapDtoToEntity(dto);
        return repository.save(question);
    }

    public Question getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        Question question = getOrThrow404(id);
        repository.delete(question);
    }

    public Question update(Long id, QuestionDto dto){
        Question question = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, question);
        return repository.save(question);
    }

    private Question getOrThrow404(Long id){
        Optional<Question> question = repository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            throw new ResourceNotFoundException("Question with given id [ " + id + " ] does not exist");
        }
    }

}
