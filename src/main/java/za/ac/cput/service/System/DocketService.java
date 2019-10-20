package za.ac.cput.service.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.Docket;

import java.util.List;


@Service
public interface DocketService extends JpaRepository<Docket, Long> {
    List<Docket> findByName(String name);
}