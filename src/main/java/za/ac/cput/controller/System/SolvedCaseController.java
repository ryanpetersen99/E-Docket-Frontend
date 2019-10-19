package za.ac.cput.controller.System;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.repository.System.SolvedCaseRepository;


@Controller
@RequestMapping("/solvedCases/")
public class SolvedCaseController {

    private final SolvedCaseRepository solvedCaseRepository;

    @Autowired
    public SolvedCaseController(SolvedCaseRepository solvedCaseRepository) {
        this.solvedCaseRepository = solvedCaseRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(SolvedCase solvedCase) {
        return "add-solvedCase";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("solvedCases", solvedCaseRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addSolvedCase(@Valid SolvedCase solvedCase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-solvedCase";
        }

        solvedCaseRepository.save(solvedCase);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        SolvedCase solvedCase = solvedCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid solvedCase Id:" + id));
        model.addAttribute("solvedCase", solvedCase);
        return "update-solvedCase";
    }

    @PostMapping("update/{id}")
    public String updateSolvedCase(@PathVariable("id") long id, @Valid SolvedCase solvedCase, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            solvedCase.setId(id);
            return "update-solvedCase";
        }

        solvedCaseRepository.save(solvedCase);
        model.addAttribute("solvedCases", solvedCaseRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteSolvedCase(@PathVariable("id") long id, Model model) {
        SolvedCase solvedCase = solvedCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid solvedCase Id:" + id));
        solvedCaseRepository.delete(solvedCase);
        model.addAttribute("solvedCases", solvedCaseRepository.findAll());
        return "index";
    }
}