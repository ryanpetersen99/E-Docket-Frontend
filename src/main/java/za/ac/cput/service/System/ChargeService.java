package za.ac.cput.service.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.Charge;

import java.util.List;


@Service
public interface ChargeService extends JpaRepository<Charge, Long> {
    List<Charge> findByName(String name);
}