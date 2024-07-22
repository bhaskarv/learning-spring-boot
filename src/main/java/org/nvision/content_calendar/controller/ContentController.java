package org.nvision.content_calendar.controller;

import jakarta.validation.Valid;
import org.nvision.content_calendar.model.Content;
import org.nvision.content_calendar.model.Status;
import org.nvision.content_calendar.repository.ContentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") // Defaults to class level request mapping
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}") // URL : /api/content/{id}
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content is not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody  Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody  Content content, @PathVariable Integer id){
        if (repository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " CONTENT NOT FOUND");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public  void  delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/title/{keyword}")
    public List<Content> findAllBy(@PathVariable  String keyword) {
        return  repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{st}")
    public List<Content> findAllByStatus(@PathVariable Status st) {
        return  repository.findByStatus(st);
    }

}
