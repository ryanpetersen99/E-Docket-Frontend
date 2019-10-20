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
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.repository.Civilian.ComplainantRepository;


@Controller
@RequestMapping("/complainants/")
public class ComplainantController {

    private final ComplainantRepository complainantRepository;

    @Autowired
    public ComplainantController(ComplainantRepository complainantRepository) {
        this.complainantRepository = complainantRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Complainant complainant) {
        return "complainant/add-complainant";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("complainants", complainantRepository.findAll());
        return "complainant/complainant";
    }

    @PostMapping("add")
    public String addComplainant(@Valid Complainant complainant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "complainant/add-complainant";
        }

        complainantRepository.save(complainant);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Complainant complainant = complainantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid complainant Id:" + id));
        model.addAttribute("complainant", complainant);
        return "complainant/update-complainant";
    }

    @PostMapping("update/{id}")
    public String updateComplainant(@PathVariable("id") long id, @Valid Complainant complainant, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            complainant.setId(id);
            return "complainant/update-complainant";
        }

        complainantRepository.save(complainant);
        model.addAttribute("complainants", complainantRepository.findAll());
        return "complainant/complainant";
    }

    @GetMapping("delete/{id}")
    public String deleteComplainant(@PathVariable("id") long id, Model model) {
        Complainant complainant = complainantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid complainant Id:" + id));
        complainantRepository.delete(complainant);
        model.addAttribute("complainants", complainantRepository.findAll());
        return "complainant/complainant";
    }
}