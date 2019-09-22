package za.ac.cput.controller.Civilian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.service.Civilian.implementation.WitnessServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/witness")
public class WitnessController {

    @Autowired
    @Qualifier("WitnessServiceImplementation")
    private WitnessServiceImplementation witnessServiceImplementation;

    @PostMapping("/new")
    public Witness create(@RequestBody Witness create) {

        return witnessServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Witness findById(@PathVariable String id) {

        Witness read = witnessServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Witness update) {


        witnessServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        witnessServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Witness> getAll() {
        return witnessServiceImplementation.getWitnessSet();
    }
}