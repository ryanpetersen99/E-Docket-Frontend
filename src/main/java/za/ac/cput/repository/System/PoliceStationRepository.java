package za.ac.cput.repository.System;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.PoliceStation;


@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {
    List<PoliceStation> findByName(String name);
}