package za.ac.cput.controller.Police;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.repository.Police.ChiefRepository;


@Controller
@RequestMapping("/chiefs/")
public class ChiefController {

    private final ChiefRepository chiefRepository;

    @Autowired
    public ChiefController(ChiefRepository chiefRepository) {
        this.chiefRepository = chiefRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Chief chief) {
        return "add-chief";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("chiefs", chiefRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addChief(@Valid Chief chief, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-chief";
        }

        chiefRepository.save(chief);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Chief chief = chiefRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid chief Id:" + id));
        model.addAttribute("chief", chief);
        return "update-chief";
    }

    @PostMapping("update/{id}")
    public String updateChief(@PathVariable("id") long id, @Valid Chief chief, BindingResult result,
                                      Model model) {
        if (result.hasErrors()) {
            chief.setId(id);
            return "update-chief";
        }

        chiefRepository.save(chief);
        model.addAttribute("chiefs", chiefRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteChief(@PathVariable("id") long id, Model model) {
        Chief chief = chiefRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid chief Id:" + id));
        chiefRepository.delete(chief);
        model.addAttribute("chiefs", chiefRepository.findAll());
        return "index";
    }
}