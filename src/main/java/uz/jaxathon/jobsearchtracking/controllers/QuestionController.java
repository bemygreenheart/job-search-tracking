package uz.jaxathon.jobsearchtracking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.jaxathon.jobsearchtracking.dto.QuestionDto;
import uz.jaxathon.jobsearchtracking.entities.Question;
import uz.jaxathon.jobsearchtracking.services.QuestionService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping(path = "")
    public Page<Question> getAll(Pageable page){
        return questionService.getAll(page);
    }

    @PostMapping(path = "")
    public Question create(@Valid @RequestBody QuestionDto body){
        return questionService.create(body);
    }

    @GetMapping(path = "/{questionId}")
    public Question getOne(@PathVariable Long questionId){
        return questionService.getById(questionId);
    }

    @DeleteMapping(path = "/{questionId}")
    public void delete(@PathVariable Long questionId){
        questionService.delete(questionId);
    }

    @PutMapping(path = "/{questionId}")
    public Question update(@PathVariable Long questionId, @Valid @RequestBody QuestionDto body){
        return questionService.update(questionId, body);
    }
}
