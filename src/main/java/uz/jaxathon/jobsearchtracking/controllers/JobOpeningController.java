package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.JobOpeningDto;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.services.JobOpeningService;

@RequiredArgsConstructor
@RequestMapping("/openings")
@RestController
public class JobOpeningController {
    private final JobOpeningService openingService;

    @GetMapping(path = "")
    public Page<JobOpening> getAll(Pageable page){
        return openingService.getAll(page);
    }

    @PostMapping (path = "")
    public JobOpening create(@RequestBody JobOpeningDto body){
        return openingService.create(body);
    }

    @GetMapping(path = "/{id}")
    public JobOpening getOne(@PathVariable Long id){
        return openingService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        openingService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public JobOpening update(@PathVariable Long id, @RequestBody JobOpeningDto body){
        return openingService.update(id, body);
    }

}
