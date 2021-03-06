package za.ac.cput.service.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.SolvedCase;

import java.util.List;


@Service
public interface SolvedCaseService extends JpaRepository<SolvedCase, Long> {
    List<SolvedCase> findByName(String name);
}