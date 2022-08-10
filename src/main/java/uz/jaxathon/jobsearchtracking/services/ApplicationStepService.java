package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.ApplicationStepMapper;
import uz.jaxathon.jobsearchtracking.repos.ApplicationStepRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ApplicationStepService {

    private final ApplicationStepRepository repository;
    private final ApplicationStepMapper mapper;

    public Page<ApplicationStep> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public ApplicationStep create(ApplicationStepDto dto){
        ApplicationStep applicationStep = mapper.mapDtoToEntity(dto);
        return repository.save(applicationStep);
    }

    public ApplicationStep getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        ApplicationStep applicationStep = getOrThrow404(id);
        repository.delete(applicationStep);
    }

    public ApplicationStep update(Long id, ApplicationStepDto dto){
        ApplicationStep applicationStep = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, applicationStep);
        return repository.save(applicationStep);
    }

    private ApplicationStep getOrThrow404(Long id){
        Optional<ApplicationStep> applicationStep = repository.findById(id);
        if(applicationStep.isPresent()){
            return applicationStep.get();
        }else{
            throw new ResourceNotFoundException("Application step with given id [ " + id + " ] does not exist");
        }
    }

}
