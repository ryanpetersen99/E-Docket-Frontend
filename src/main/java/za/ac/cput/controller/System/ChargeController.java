package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.service.System.implementation.ChargeServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/charge")
public class ChargeController {

    @Autowired
    @Qualifier("ChargeServiceImplementation")
    private ChargeServiceImplementation chargeServiceImplementation;

    @PostMapping("/new")
    public Charge create(@RequestBody Charge create) {

        return chargeServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Charge findById(@PathVariable String id) {

        Charge read = chargeServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Charge update) {

        chargeServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        chargeServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Charge> getAll() {
        return chargeServiceImplementation.getChargeSet();
    }


}