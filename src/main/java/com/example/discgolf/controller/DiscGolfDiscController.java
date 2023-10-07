package com.example.discgolf.controller;

import com.example.discgolf.model.DiscGolfDisc;
import com.example.discgolf.service.DiscGolfDiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discs")
public class DiscGolfDiscController {

    private final DiscGolfDiscService service;

    @Autowired
    public DiscGolfDiscController(DiscGolfDiscService service) {
        this.service = service;
    }

    @GetMapping
    public List<DiscGolfDisc> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DiscGolfDisc findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DiscGolfDisc save(@RequestBody DiscGolfDisc disc) {
        return service.save(disc);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
