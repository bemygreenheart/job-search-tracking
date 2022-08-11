package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.RecruiterDto;
import uz.jaxathon.jobsearchtracking.entities.Recruiter;
import uz.jaxathon.jobsearchtracking.services.RecruiterService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/recruiters")
@RestController
public class RecruiterController {

    private final RecruiterService recruiterService;

    @GetMapping(path = "")
    public Page<Recruiter> getAll(Pageable page){
        return recruiterService.getAll(page);
    }

    @PostMapping(path = "")
    public Recruiter create(@Valid @RequestBody RecruiterDto body){
        return recruiterService.create(body);
    }

    @GetMapping(path = "/{recruiterId}")
    public Recruiter getOne(@PathVariable Long recruiterId){
        return recruiterService.getById(recruiterId);
    }

    @DeleteMapping(path = "/{recruiterId}")
    public void delete(@PathVariable Long recruiterId){
        recruiterService.delete(recruiterId);
    }

    @PutMapping(path = "/{recruiterId}")
    public Recruiter update(@PathVariable Long recruiterId, @Valid @RequestBody RecruiterDto body){
        return recruiterService.update(recruiterId, body);
    }
}
