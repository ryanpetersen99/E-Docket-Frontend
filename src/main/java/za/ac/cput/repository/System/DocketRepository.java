package za.ac.cput.repository.System;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Docket;


@Repository
public interface DocketRepository extends JpaRepository<Docket, Long> {
    List<Docket> findByName(String name);
}