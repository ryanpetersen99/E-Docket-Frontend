package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.service.System.implementation.EvidenceServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    @Autowired
    @Qualifier("EvidenceServiceImplementation")
    private EvidenceServiceImplementation evidenceServiceImplementation;

    @PostMapping("/new")
    public Evidence create(@RequestBody Evidence create) {

        return evidenceServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public Evidence findById(@PathVariable String id) {

        Evidence read = evidenceServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody Evidence update) {

        evidenceServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        evidenceServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Evidence> getAll() {
        return evidenceServiceImplementation.getEvidenceSet();
    }


}