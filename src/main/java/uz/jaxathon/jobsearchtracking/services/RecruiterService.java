package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.RecruiterDto;
import uz.jaxathon.jobsearchtracking.entities.Recruiter;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.RecruiterMapper;
import uz.jaxathon.jobsearchtracking.repos.RecruiterRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecruiterService {

    private final RecruiterRepository repository;
    private final RecruiterMapper mapper;

    public Page<Recruiter> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public Recruiter create(RecruiterDto dto){
        Recruiter recruiter = mapper.mapDtoToEntity(dto);
        return repository.save(recruiter);
    }

    public Recruiter getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        Recruiter recruiter = getOrThrow404(id);
        repository.delete(recruiter);
    }

    public Recruiter update(Long id, RecruiterDto dto){
        Recruiter recruiter = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, recruiter);
        return repository.save(recruiter);
    }

    private Recruiter getOrThrow404(Long id){
        Optional<Recruiter> recruiter = repository.findById(id);
        if(recruiter.isPresent()){
            return recruiter.get();
        }else{
            throw new ResourceNotFoundException("Recruiter with given id [ " + id + " ] does not exist");
        }
    }

}
