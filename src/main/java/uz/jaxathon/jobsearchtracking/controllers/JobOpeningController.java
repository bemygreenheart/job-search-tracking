package uz.jaxathon.jobsearchtracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.services.JobOpeningService;

import java.util.List;

@RestController
public class JobOpeningController {
    private JobOpeningService openingService;

    @Autowired
    public JobOpeningController(JobOpeningService openingService) {
        this.openingService = openingService;
    }

    @GetMapping(path = "/openings")
    public List<JobOpening> getAllJobOpenings(){
        return openingService.getAllOpenings();
    }
}
