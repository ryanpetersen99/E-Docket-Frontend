package za.ac.cput.controller.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.service.System.implementation.SolvedCaseServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/solvedCase")
public class SolvedCaseController {

    @Autowired
    @Qualifier("SolvedCaseServiceImplementation")
    private SolvedCaseServiceImplementation solvedCaseServiceImplementation;

    @PostMapping("/new")
    public SolvedCase create(@RequestBody SolvedCase create) {

        return solvedCaseServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public SolvedCase findById(@PathVariable String id) {

        SolvedCase read = solvedCaseServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody SolvedCase update) {

        solvedCaseServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        solvedCaseServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<SolvedCase> getAll() {
        return solvedCaseServiceImplementation.getSolvedCase();
    }


}