package za.ac.cput.controller.Civilian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.service.Civilian.implementation.ComplainantServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/complainant")
public class ComplainantController {

    @Autowired
    @Qualifier("complainantServiceImplementation")
    private ComplainantServiceImplementation complainantServiceImplementation;

    @PostMapping("/new")
    public Complainant create(@RequestBody Complainant create) {

        return complainantServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Complainant findById(@PathVariable String id) {

        Complainant read = complainantServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Complainant update) {

        complainantServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        complainantServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Complainant> getAll() {
        return complainantServiceImplementation.getComplainantSet();
    }


}
