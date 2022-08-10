package uz.jaxathon.jobsearchtracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.repos.JobOpeningRepository;

import java.util.List;

@Service
public class JobOpeningService {

    private final JobOpeningRepository repository;

    @Autowired
    public JobOpeningService(JobOpeningRepository repository) {
        this.repository = repository;
    }

    public Page<JobOpening> getAllOpenings(Pageable page) {
        return repository.findAll(page);
    }


}
