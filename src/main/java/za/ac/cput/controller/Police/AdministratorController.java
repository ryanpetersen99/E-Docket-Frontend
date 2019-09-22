package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.service.Police.implementation.AdministratorServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    @Qualifier("AdministratorServiceImplementation")
    private AdministratorServiceImplementation administratorServiceImplementation;

    @PostMapping("/new")
    public Administrator create(@RequestBody Administrator create) {

        return administratorServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Administrator findById(@PathVariable String id) {

        Administrator read = administratorServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Administrator update) {

        administratorServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        administratorServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Administrator> getAll() {
        return administratorServiceImplementation.getAdministratorSet();
    }


}