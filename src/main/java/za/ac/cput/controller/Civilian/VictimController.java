package za.ac.cput.controller.Civilian;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.repository.Civilian.VictimRepository;


@Controller
@RequestMapping("/victims/")
public class VictimController {

    private final VictimRepository victimRepository;

    @Autowired
    public VictimController(VictimRepository victimRepository) {
        this.victimRepository = victimRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Victim victim) {
        return "add-victim";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("victims", victimRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addVictim(@Valid Victim victim, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-victim";
        }

        victimRepository.save(victim);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Victim victim = victimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid victim Id:" + id));
        model.addAttribute("victim", victim);
        return "update-victim";
    }

    @PostMapping("update/{id}")
    public String updateVictim(@PathVariable("id") long id, @Valid Victim victim, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            victim.setId(id);
            return "update-victim";
        }

        victimRepository.save(victim);
        model.addAttribute("victims", victimRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteVictim(@PathVariable("id") long id, Model model) {
        Victim victim = victimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid victim Id:" + id));
        victimRepository.delete(victim);
        model.addAttribute("victims", victimRepository.findAll());
        return "index";
    }
}