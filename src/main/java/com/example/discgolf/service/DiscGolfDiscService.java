package com.example.discgolf.service;

import com.example.discgolf.model.DiscGolfDisc;
import com.example.discgolf.repository.DiscGolfDiscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscGolfDiscService {

    private final DiscGolfDiscRepository repository;

    @Autowired
    public DiscGolfDiscService(DiscGolfDiscRepository repository) {
        this.repository = repository;
    }
    // CRUD methods for DiscGolfDisc entity
    public List<DiscGolfDisc> findAll() {
        return repository.findAll();
    }

    public DiscGolfDisc findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DiscGolfDisc save(DiscGolfDisc disc) {
        return repository.save(disc);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
