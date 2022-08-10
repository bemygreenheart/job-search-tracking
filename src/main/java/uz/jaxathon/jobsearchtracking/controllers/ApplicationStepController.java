package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.ApplicationStepDto;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;
import uz.jaxathon.jobsearchtracking.services.ApplicationStepService;

@RequiredArgsConstructor
@RequestMapping("/applications/{applicationId}/steps")
@RestController
public class ApplicationStepController {

    private final ApplicationStepService applicationStepService;

    @GetMapping(path = "")
    public Page<ApplicationStep> getAll(Pageable page, @PathVariable String applicationId){
        return applicationStepService.getAll(page);
    }

    @PostMapping(path = "")
    public ApplicationStep create(@RequestBody ApplicationStepDto body, @PathVariable String applicationId){
        return applicationStepService.create(body);
    }

    @GetMapping(path = "/{stepId}")
    public ApplicationStep getOne(@PathVariable Long stepId, @PathVariable String applicationId){
        return applicationStepService.getById(stepId);
    }

    @DeleteMapping(path = "/{stepId}")
    public void delete(@PathVariable Long stepId, @PathVariable String applicationId){
        applicationStepService.delete(stepId);
    }

    @PutMapping(path = "/{stepId}")
    public ApplicationStep update(@PathVariable Long stepId, @RequestBody ApplicationStepDto body, @PathVariable String applicationId){
        return applicationStepService.update(stepId, body);
    }
}
