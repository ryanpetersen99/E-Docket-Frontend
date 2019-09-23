package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.service.Police.implementation.OfficerServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/officer")
public class OfficerController {

    @Autowired
    @Qualifier("OfficerServiceImplementation")
    private OfficerServiceImplementation officerServiceImplementation;

    @PostMapping("/new")
    public Officer create(@RequestBody Officer create) {

        return officerServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Officer findById(@PathVariable String id) {

        Officer read = officerServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Officer update) {

        officerServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        officerServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Officer> getAll() {
        return officerServiceImplementation.getAll();
    }


}