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
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.repository.System.EvidenceRepository;


@Controller
@RequestMapping("/evidences/")
public class EvidenceController {

    private final EvidenceRepository evidenceRepository;

    @Autowired
    public EvidenceController(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Evidence evidence) {
        return "add-evidence";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("evidences", evidenceRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addEvidence(@Valid Evidence evidence, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-evidence";
        }

        evidenceRepository.save(evidence);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Evidence evidence = evidenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid evidence Id:" + id));
        model.addAttribute("evidence", evidence);
        return "update-evidence";
    }

    @PostMapping("update/{id}")
    public String updateEvidence(@PathVariable("id") long id, @Valid Evidence evidence, BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            evidence.setId(id);
            return "update-evidence";
        }

        evidenceRepository.save(evidence);
        model.addAttribute("evidences", evidenceRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteEvidence(@PathVariable("id") long id, Model model) {
        Evidence evidence = evidenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid evidence Id:" + id));
        evidenceRepository.delete(evidence);
        model.addAttribute("evidences", evidenceRepository.findAll());
        return "index";
    }
}