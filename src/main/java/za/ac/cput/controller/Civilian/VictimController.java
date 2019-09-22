package za.ac.cput.controller.Civilian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.service.Civilian.implementation.VictimServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/victim")
public class VictimController {

    @Autowired
    @Qualifier("VictimServiceImplementation")
    private VictimServiceImplementation victimServiceImplementation;

    @PostMapping("/new")
    public Victim create(@RequestBody Victim create) {

        return victimServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Victim findById(@PathVariable String id) {

        Victim read = victimServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Victim update) {

        victimServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        victimServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Victim> getAll() {
        return victimServiceImplementation.getVictimSet();
    }
}

