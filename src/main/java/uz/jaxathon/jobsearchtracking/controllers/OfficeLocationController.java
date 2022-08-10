package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.OfficeLocationDto;
import uz.jaxathon.jobsearchtracking.entities.OfficeLocation;
import uz.jaxathon.jobsearchtracking.services.OfficeLocationService;

@RequiredArgsConstructor
@RequestMapping("/office-locations")
@RestController
public class OfficeLocationController {

    private final OfficeLocationService locationService;

    @GetMapping(path = "")
    public Page<OfficeLocation> getAll(Pageable page){
        return locationService.getAll(page);
    }

    @PostMapping(path = "")
    public OfficeLocation create(@RequestBody OfficeLocationDto body){
        return locationService.create(body);
    }

    @GetMapping(path = "/{locationId}")
    public OfficeLocation getOne(@PathVariable Long locationId){
        return locationService.getById(locationId);
    }

    @DeleteMapping(path = "/{locationId}")
    public void delete(@PathVariable Long locationId){
        locationService.delete(locationId);
    }

    @PutMapping(path = "/{locationId}")
    public OfficeLocation update(@PathVariable Long locationId, @RequestBody OfficeLocationDto body){
        return locationService.update(locationId, body);
    }
}
