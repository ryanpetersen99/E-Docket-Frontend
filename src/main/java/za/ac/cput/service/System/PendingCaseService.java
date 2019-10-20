package za.ac.cput.service.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.PendingCase;

import java.util.List;


@Service
public interface PendingCaseService extends JpaRepository<PendingCase, Long> {
    List<PendingCase> findByName(String name);
}