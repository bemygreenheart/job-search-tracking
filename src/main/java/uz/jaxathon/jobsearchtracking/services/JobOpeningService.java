package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.JobOpeningDto;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.JobOpeningMapper;
import uz.jaxathon.jobsearchtracking.repos.JobOpeningRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobOpeningService {

    private final JobOpeningRepository repository;
    private final JobOpeningMapper mapper;

    public Page<JobOpening> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public JobOpening create(JobOpeningDto dto){
        JobOpening entity = mapper.mapDtoToEntity(dto);
        return repository.save(entity);
    }

    public JobOpening getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        JobOpening opening = getOrThrow404(id);
        repository.delete(opening);
    }

    public JobOpening update(Long id, JobOpeningDto dto){
        JobOpening opening = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, opening);
        return repository.save(opening);
    }

    private JobOpening getOrThrow404(Long id){
        Optional<JobOpening> jobOpening = repository.findById(id);
        if(jobOpening.isPresent()){
            return jobOpening.get();
        }else{
            throw new ResourceNotFoundException("Job opening with given id [ " + id + " ] does not exist");
        }
    }

}
