package za.ac.cput.service.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.PoliceStation;

import java.util.List;


@Service
public interface PoliceStationService extends JpaRepository<PoliceStation, Long> {
    List<PoliceStation> findByName(String name);
}