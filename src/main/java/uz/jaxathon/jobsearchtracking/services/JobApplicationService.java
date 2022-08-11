package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.JobApplicationDto;
import uz.jaxathon.jobsearchtracking.entities.JobApplication;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.JobApplicationMapper;
import uz.jaxathon.jobsearchtracking.repos.JobApplicationRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;
    private final JobApplicationMapper mapper;

    public Page<JobApplication> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public JobApplication create(JobApplicationDto dto){
        JobApplication application = mapper.mapDtoToEntity(dto);
        return repository.save(application);
    }

    public JobApplication getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        JobApplication application = getOrThrow404(id);
        repository.delete(application);
    }

    public JobApplication update(Long id, JobApplicationDto dto){
        JobApplication application = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, application);
        return repository.save(application);
    }

     JobApplication getOrThrow404(Long id){
        Optional<JobApplication> application = repository.findById(id);
        if(application.isPresent()){
            return application.get();
        }else{
            throw new ResourceNotFoundException("Job Application with given id [ " + id + " ] does not exist");
        }
    }

}
