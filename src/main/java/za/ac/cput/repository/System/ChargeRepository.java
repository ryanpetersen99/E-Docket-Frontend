package za.ac.cput.repository.System;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Charge;


@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
    List<Charge> findByName(String name);
}