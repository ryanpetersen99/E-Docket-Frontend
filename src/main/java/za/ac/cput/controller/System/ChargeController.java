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
import za.ac.cput.domain.System.Charge;
import za.ac.cput.repository.System.ChargeRepository;


@Controller
@RequestMapping("/charges/")
public class ChargeController {

    private final ChargeRepository chargeRepository;

    @Autowired
    public ChargeController(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Charge charge) {
        return "add-charge";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("charges", chargeRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addCharge(@Valid Charge charge, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-charge";
        }

        chargeRepository.save(charge);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Charge charge = chargeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid charge Id:" + id));
        model.addAttribute("charge", charge);
        return "update-charge";
    }

    @PostMapping("update/{id}")
    public String updateCharge(@PathVariable("id") long id, @Valid Charge charge, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            charge.setId(id);
            return "update-charge";
        }

        chargeRepository.save(charge);
        model.addAttribute("charges", chargeRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteCharge(@PathVariable("id") long id, Model model) {
        Charge charge = chargeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid charge Id:" + id));
        chargeRepository.delete(charge);
        model.addAttribute("charges", chargeRepository.findAll());
        return "index";
    }
}