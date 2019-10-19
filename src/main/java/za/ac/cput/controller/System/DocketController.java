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
import za.ac.cput.domain.System.Docket;
import za.ac.cput.repository.System.DocketRepository;


@Controller
@RequestMapping("/dockets/")
public class DocketController {

    private final DocketRepository docketRepository;

    @Autowired
    public DocketController(DocketRepository docketRepository) {
        this.docketRepository = docketRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Docket docket) {
        return "add-docket";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("dockets", docketRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addDocket(@Valid Docket docket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-docket";
        }

        docketRepository.save(docket);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Docket docket = docketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid docket Id:" + id));
        model.addAttribute("docket", docket);
        return "update-docket";
    }

    @PostMapping("update/{id}")
    public String updateDocket(@PathVariable("id") long id, @Valid Docket docket, BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            docket.setId(id);
            return "update-docket";
        }

        docketRepository.save(docket);
        model.addAttribute("dockets", docketRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteDocket(@PathVariable("id") long id, Model model) {
        Docket docket = docketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid docket Id:" + id));
        docketRepository.delete(docket);
        model.addAttribute("dockets", docketRepository.findAll());
        return "index";
    }
}