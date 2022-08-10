package uz.jaxathon.jobsearchtracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.JobOpeningDto;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.services.JobOpeningService;

@RestController
public class JobOpeningController {
    private JobOpeningService openingService;

    @Autowired
    public JobOpeningController(JobOpeningService openingService) {
        this.openingService = openingService;
    }

    @GetMapping(path = "/openings")
    public Page<JobOpening> getAllJobOpenings(Pageable page){
        return openingService.getAllJobOpenings(page);
    }

    @PostMapping (path = "/openings")
    public JobOpening create(@RequestBody JobOpeningDto body){
        return openingService.createJobOpening(body);
    }

    @GetMapping(path = "/openings/{id}")
    public JobOpening getOne(@PathVariable Long id){
        return openingService.getJobOpeningById(id);
    }

    @DeleteMapping(path = "/openings/{id}")
    public void delete(@PathVariable Long id){
        openingService.deleteJobOpening(id);
    }

    @PutMapping(path = "/openings/{id}")
    public JobOpening update(@PathVariable Long id, @RequestBody JobOpeningDto body){
        return openingService.updateJobOpening(id, body);
    }


}
