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
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.repository.Civilian.SuspectRepository;


@Controller
@RequestMapping("/suspects/")
public class SuspectController {

    private final SuspectRepository suspectRepository;

    @Autowired
    public SuspectController(SuspectRepository suspectRepository) {
        this.suspectRepository = suspectRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Suspect suspect) {
        return "add-suspect";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("suspects", suspectRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addSuspect(@Valid Suspect suspect, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-suspect";
        }

        suspectRepository.save(suspect);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Suspect suspect = suspectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid suspect Id:" + id));
        model.addAttribute("suspect", suspect);
        return "update-suspect";
    }

    @PostMapping("update/{id}")
    public String updateSuspect(@PathVariable("id") long id, @Valid Suspect suspect, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            suspect.setId(id);
            return "update-suspect";
        }

        suspectRepository.save(suspect);
        model.addAttribute("suspects", suspectRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteSuspect(@PathVariable("id") long id, Model model) {
        Suspect suspect = suspectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid suspect Id:" + id));
        suspectRepository.delete(suspect);
        model.addAttribute("suspects", suspectRepository.findAll());
        return "index";
    }
}