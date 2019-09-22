package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.Docket;
import za.ac.cput.service.System.implementation.DocketServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/docket")
public class DocketController {

    @Autowired
    @Qualifier("DocketServiceImplementation")
    private DocketServiceImplementation docketServiceImplementation;

    @PostMapping("/new")
    public Docket create(@RequestBody Docket create) {

        return docketServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Docket findById(@PathVariable String id) {

        Docket read = docketServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Docket update) {

        docketServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        docketServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Docket> getAll() {
        return docketServiceImplementation.getDocketSet();
    }


}