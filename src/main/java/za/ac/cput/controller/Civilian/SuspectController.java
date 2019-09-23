package za.ac.cput.controller.Civilian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.service.Civilian.implementation.SuspectServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/suspect")
public class SuspectController {

    @Autowired
    @Qualifier("SuspectServiceImplementation")
    private SuspectServiceImplementation suspectServiceImplementation;

    @PostMapping("/new")
    public Suspect create(@RequestBody Suspect create) {

        return suspectServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Suspect findById(@PathVariable String id) {

        Suspect read = suspectServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Suspect update) {

        suspectServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        suspectServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Suspect> getAll() {
        return suspectServiceImplementation.getAll();
    }


}