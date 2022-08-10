package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.SkillDto;
import uz.jaxathon.jobsearchtracking.entities.Skill;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.SkillMapper;
import uz.jaxathon.jobsearchtracking.repos.SkillRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SkillService {

    private final SkillRepository repository;
    private final SkillMapper mapper;

    public Page<Skill> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public Skill create(SkillDto dto){
        Skill skill = mapper.mapDtoToEntity(dto);
        return repository.save(skill);
    }

    public Skill getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        Skill skill = getOrThrow404(id);
        repository.delete(skill);
    }

    public Skill update(Long id, SkillDto dto){
        Skill skill = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, skill);
        return repository.save(skill);
    }

    private Skill getOrThrow404(Long id){
        Optional<Skill> skill = repository.findById(id);
        if(skill.isPresent()){
            return skill.get();
        }else{
            throw new ResourceNotFoundException("Skill with given id [ " + id + " ] does not exist");
        }
    }

}
