package uz.jaxathon.jobsearchtracking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jaxathon.jobsearchtracking.entities.OfficeLocation;

@Repository
public interface OfficeLocationRepository extends JpaRepository<OfficeLocation, Long> {
}
