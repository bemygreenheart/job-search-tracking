package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.JobApplicationDto;
import uz.jaxathon.jobsearchtracking.entities.JobApplication;
import uz.jaxathon.jobsearchtracking.services.JobApplicationService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/applications")
@RestController
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping(path = "")
    public Page<JobApplication> getAll(Pageable page){
        return jobApplicationService.getAll(page);
    }

    @PostMapping (path = "")
    public JobApplication create(@Valid @RequestBody JobApplicationDto body){
        return jobApplicationService.create(body);
    }

    @GetMapping(path = "/{id}")
    public JobApplication getOne(@PathVariable Long id){
        return jobApplicationService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        jobApplicationService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public JobApplication update(@PathVariable Long id, @Valid @RequestBody JobApplicationDto body){
        return jobApplicationService.update(id, body);
    }

}
