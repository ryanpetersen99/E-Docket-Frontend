package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.service.Police.implementation.InspectorServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

    @Autowired
    @Qualifier("InspectorServiceImplementation")
    private InspectorServiceImplementation inspectorServiceImplementation;

    @PostMapping("/new")
    public Inspector create(@RequestBody Inspector create) {

        return inspectorServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Inspector findById(@PathVariable String id) {

        Inspector read = inspectorServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Inspector update) {

        inspectorServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        inspectorServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Inspector> getAll() {
        return inspectorServiceImplementation.getInspectorSet();
    }


}