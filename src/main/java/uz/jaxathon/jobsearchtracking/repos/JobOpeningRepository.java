package uz.jaxathon.jobsearchtracking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jaxathon.jobsearchtracking.entities.JobOpening;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {




}
