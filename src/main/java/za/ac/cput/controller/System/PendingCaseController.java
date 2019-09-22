package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.service.System.implementation.PendingCaseServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/pendingCase")
public class PendingCaseController {

    @Autowired
    @Qualifier("PendingCaseServiceImplementation")
    private PendingCaseServiceImplementation pendingCaseServiceImplementation;

    @PostMapping("/new")
    public PendingCase create(@RequestBody PendingCase create) {

        return pendingCaseServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public PendingCase findById(@PathVariable String id) {

        PendingCase read = pendingCaseServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody PendingCase update) {

        pendingCaseServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        pendingCaseServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<PendingCase> getAll() {
        return pendingCaseServiceImplementation.getPendingCaseSet();
    }


}