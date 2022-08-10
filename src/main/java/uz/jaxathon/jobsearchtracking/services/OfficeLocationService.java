package uz.jaxathon.jobsearchtracking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jaxathon.jobsearchtracking.dto.OfficeLocationDto;
import uz.jaxathon.jobsearchtracking.entities.OfficeLocation;
import uz.jaxathon.jobsearchtracking.exceptions.ResourceNotFoundException;
import uz.jaxathon.jobsearchtracking.mappers.OfficeLocationMapper;
import uz.jaxathon.jobsearchtracking.repos.OfficeLocationRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OfficeLocationService {

    private final OfficeLocationRepository repository;
    private final OfficeLocationMapper mapper;

    public Page<OfficeLocation> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public OfficeLocation create(OfficeLocationDto dto){
        OfficeLocation entity = mapper.mapDtoToEntity(dto);
        return repository.save(entity);
    }

    public OfficeLocation getById(Long id){
        return getOrThrow404(id);
    }

    public void delete(Long id){
        OfficeLocation officeLocation = getOrThrow404(id);
        repository.delete(officeLocation);
    }

    public OfficeLocation update(Long id, OfficeLocationDto dto){
        OfficeLocation officeLocation = getOrThrow404(id);
        mapper.updateEntityFromDto(dto, officeLocation);
        return repository.save(officeLocation);
    }

    private OfficeLocation getOrThrow404(Long id){
        Optional<OfficeLocation> officeLocation = repository.findById(id);
        if(officeLocation.isPresent()){
            return officeLocation.get();
        }else{
            throw new ResourceNotFoundException("Job opening with given id [ " + id + " ] does not exist");
        }
    }

}
