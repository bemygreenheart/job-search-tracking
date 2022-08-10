package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.SkillDto;
import uz.jaxathon.jobsearchtracking.entities.Skill;
import uz.jaxathon.jobsearchtracking.services.SkillService;

@RequiredArgsConstructor
@RequestMapping("/skills")
@RestController
public class SkillController {
    private final SkillService skillService;

    @GetMapping(path = "")
    public Page<Skill> getAll(Pageable page){
        return skillService.getAll(page);
    }

    @PostMapping(path = "")
    public Skill create(@RequestBody SkillDto body){
        return skillService.create(body);
    }

    @GetMapping(path = "/{id}")
    public Skill getOne(@PathVariable Long id){
        return skillService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        skillService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Skill update(@PathVariable Long id, @RequestBody SkillDto body){
        return skillService.update(id, body);
    }
}
