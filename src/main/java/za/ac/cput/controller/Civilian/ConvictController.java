package za.ac.cput.controller.Civilian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.service.Civilian.implementation.ConvictServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/convict")
public class ConvictController {

    @Autowired
    @Qualifier("ConvictServiceImplementation")
    private ConvictServiceImplementation convictServiceImplementation;

    @PostMapping("/new")
    public Convict create(@RequestBody Convict create) {

        return convictServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Convict findById(@PathVariable String id) {

        Convict read = convictServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Convict update) {

        convictServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        convictServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Convict> getAll() {
        return convictServiceImplementation.getConvictSet();
    }


}