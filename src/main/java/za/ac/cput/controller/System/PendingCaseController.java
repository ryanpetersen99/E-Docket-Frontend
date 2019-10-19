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
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.repository.System.PendingCaseRepository;


@Controller
@RequestMapping("/pendingCases/")
public class PendingCaseController {

    private final PendingCaseRepository pendingCaseRepository;

    @Autowired
    public PendingCaseController(PendingCaseRepository pendingCaseRepository) {
        this.pendingCaseRepository = pendingCaseRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(PendingCase pendingCase) {
        return "add-pendingCase";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("pendingCases", pendingCaseRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addPendingCase(@Valid PendingCase pendingCase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-pendingCase";
        }

        pendingCaseRepository.save(pendingCase);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        PendingCase pendingCase = pendingCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pendingCase Id:" + id));
        model.addAttribute("pendingCase", pendingCase);
        return "update-pendingCase";
    }

    @PostMapping("update/{id}")
    public String updatePendingCase(@PathVariable("id") long id, @Valid PendingCase pendingCase, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            pendingCase.setId(id);
            return "update-pendingCase";
        }

        pendingCaseRepository.save(pendingCase);
        model.addAttribute("pendingCases", pendingCaseRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deletePendingCase(@PathVariable("id") long id, Model model) {
        PendingCase pendingCase = pendingCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pendingCase Id:" + id));
        pendingCaseRepository.delete(pendingCase);
        model.addAttribute("pendingCases", pendingCaseRepository.findAll());
        return "index";
    }
}