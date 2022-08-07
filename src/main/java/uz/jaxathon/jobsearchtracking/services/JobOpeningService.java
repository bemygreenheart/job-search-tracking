package uz.jaxathon.jobsearchtracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;
import uz.jaxathon.jobsearchtracking.repos.JobOpeningRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobOpeningService {

    private JobOpeningRepository openingRepository;

    @Autowired
    public JobOpeningService(JobOpeningRepository openingRepository) {
        this.openingRepository = openingRepository;
    }

    public List<JobOpening> getAllOpenings() {
        return StreamSupport
                .stream(openingRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
