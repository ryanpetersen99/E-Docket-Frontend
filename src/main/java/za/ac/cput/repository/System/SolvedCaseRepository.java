package za.ac.cput.repository.System;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.SolvedCase;


@Repository
public interface SolvedCaseRepository extends JpaRepository<SolvedCase, Long> {
    List<SolvedCase> findByName(String name);
}