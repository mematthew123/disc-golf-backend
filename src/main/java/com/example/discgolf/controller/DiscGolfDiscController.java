package com.example.discgolf.controller;

import com.example.discgolf.model.DiscGolfDisc;
import com.example.discgolf.service.DiscGolfDiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.discgolf.exceptions.ResourceNotFoundException;
import com.example.discgolf.exceptions.InvalidInputException;


import java.util.List;
@CrossOrigin(origins = "*")
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
        List<DiscGolfDisc> discs = service.findAll();
        if (discs.isEmpty()) throw new ResourceNotFoundException("No discs found");
        return discs;
    }

    @GetMapping("/{id}")
    public DiscGolfDisc findById(@PathVariable Long id) {
        DiscGolfDisc disc = service.findById(id);
        if (disc == null) throw new ResourceNotFoundException("Disc not found");
        return disc;
    }

    @PostMapping
    public DiscGolfDisc save(@RequestBody DiscGolfDisc disc) {
        if (disc.getId() != null) throw new InvalidInputException("Id must be null");
        return service.save(disc);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (service.findById(id) == null) throw new ResourceNotFoundException("Disc not found");
        service.deleteById(id);
    }
}

