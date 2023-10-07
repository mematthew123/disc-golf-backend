package com.example.discgolf.repository;

import com.example.discgolf.model.DiscGolfDisc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscGolfDiscRepository extends JpaRepository<DiscGolfDisc, Long> {
}

