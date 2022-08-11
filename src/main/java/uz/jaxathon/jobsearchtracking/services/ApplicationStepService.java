package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStatus;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;
import uz.jaxathon.jobsearchtracking.entities.JobApplication;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.ApplicationStepMapper;
import uz.jaxathon.jobsearchtracking.repos.ApplicationStepRepository;
import uz.jaxathon.jobsearchtracking.repos.JobApplicationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ApplicationStepService {

    private final ApplicationStepRepository repository;
    private final JobApplicationService jobApplicationService;
    private final JobApplicationRepository jobApplicationRepository;
    private final ApplicationStepMapper mapper;

    @Transactional
    public List<ApplicationStep> getAll(Long applicationId) {
        JobApplication jobApplication = jobApplicationService.getOrThrow404(applicationId);
        return jobApplication.getApplicationSteps();
    }

    @Transactional
    public ApplicationStep create(Long applicationId, ApplicationStepDto dto){
        JobApplication jobApplication = jobApplicationService.getOrThrow404(applicationId);
        ApplicationStep applicationStep = mapper.mapDtoToEntity(dto);
        applicationStep.setJobApplication(jobApplication);
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
        ApplicationStatus oldStatus = applicationStep.getMatchingStatus();
        mapper.updateEntityFromDto(dto, applicationStep);
        applicationStep.setMatchingStatus(oldStatus);
        return repository.save(applicationStep);
    }

    ApplicationStep getOrThrow404(Long id){
        Optional<ApplicationStep> applicationStep = repository.findById(id);
        if(applicationStep.isPresent()){
            return applicationStep.get();
        }else{
            throw new ResourceNotFoundException("Application step with given id [ " + id + " ] does not exist");
        }
    }

}
