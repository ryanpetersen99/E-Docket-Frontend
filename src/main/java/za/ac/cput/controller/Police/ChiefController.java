package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.service.Police.implementation.ChiefServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/chief")
public class ChiefController {

    @Autowired
    @Qualifier("ChiefServiceImplementation")
    private ChiefServiceImplementation chiefServiceImplementation;

    @PostMapping("/new")
    public Chief create(@RequestBody Chief create) {

        return chiefServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Chief findById(@PathVariable String id) {

        Chief read = chiefServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Chief update) {

        chiefServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        chiefServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Chief> getAll() {
        return chiefServiceImplementation.getChiefSet();
    }


}