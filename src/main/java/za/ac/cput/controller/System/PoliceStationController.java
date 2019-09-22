package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.service.System.implementation.PoliceStationServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/policeStation")
public class PoliceStationController {

    @Autowired
    @Qualifier("PoliceStationServiceImplementation")
    private PoliceStationServiceImplementation policeStationServiceImplementation;

    @PostMapping("/new")
    public PoliceStation create(@RequestBody PoliceStation create) {

        return policeStationServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public PoliceStation findById(@PathVariable String id) {

        PoliceStation read = policeStationServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody PoliceStation update) {

        policeStationServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        policeStationServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<PoliceStation> getAll() {
        return policeStationServiceImplementation.getPoliceStationSet();
    }


}