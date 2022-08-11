package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;
import uz.jaxathon.jobsearchtracking.services.ApplicationStepService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/applications/{applicationId}/steps")
@RestController
public class ApplicationStepController {

    private final ApplicationStepService applicationStepService;

    @GetMapping(path = "")
    public List<ApplicationStep> getAll(@PathVariable Long applicationId){
        return applicationStepService.getAll(applicationId);
    }

    @PostMapping(path = "")
    public ApplicationStep create(@Valid @RequestBody ApplicationStepDto body, @PathVariable Long applicationId){
        return applicationStepService.create(applicationId, body);
    }

    @GetMapping(path = "/{stepId}")
    public ApplicationStep getOne(@PathVariable Long stepId, @PathVariable Long applicationId){
        return applicationStepService.getById(stepId);
    }

    @DeleteMapping(path = "/{stepId}")
    public void delete(@PathVariable Long stepId, @PathVariable Long applicationId){
        applicationStepService.delete(stepId);
    }

    @PutMapping(path = "/{stepId}")
    public ApplicationStep update(@PathVariable Long stepId, @PathVariable Long applicationId,
           @Valid @RequestBody ApplicationStepDto body){
        return applicationStepService.update(stepId, body);
    }
}
