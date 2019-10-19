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
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.repository.Civilian.WitnessRepository;


@Controller
@RequestMapping("/witnesss/")
public class WitnessController {

    private final WitnessRepository witnessRepository;

    @Autowired
    public WitnessController(WitnessRepository witnessRepository) {
        this.witnessRepository = witnessRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Witness witness) {
        return "add-witness";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("witnesss", witnessRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addWitness(@Valid Witness witness, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-witness";
        }

        witnessRepository.save(witness);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Witness witness = witnessRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid witness Id:" + id));
        model.addAttribute("witness", witness);
        return "update-witness";
    }

    @PostMapping("update/{id}")
    public String updateWitness(@PathVariable("id") long id, @Valid Witness witness, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            witness.setId(id);
            return "update-witness";
        }

        witnessRepository.save(witness);
        model.addAttribute("witnesss", witnessRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteWitness(@PathVariable("id") long id, Model model) {
        Witness witness = witnessRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid witness Id:" + id));
        witnessRepository.delete(witness);
        model.addAttribute("witnesss", witnessRepository.findAll());
        return "index";
    }
}