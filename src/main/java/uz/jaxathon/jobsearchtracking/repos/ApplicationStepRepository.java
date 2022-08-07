package uz.jaxathon.jobsearchtracking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jaxathon.jobsearchtracking.entities.ApplicationStep;

@Repository
public interface ApplicationStepRepository extends JpaRepository<ApplicationStep, Long> {
}
