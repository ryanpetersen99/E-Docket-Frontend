package za.ac.cput.repository.System;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.PendingCase;


@Repository
public interface PendingCaseRepository extends JpaRepository<PendingCase, Long> {
    List<PendingCase> findByName(String name);
}