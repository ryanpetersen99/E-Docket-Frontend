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
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.repository.Police.OfficerRepository;


@Controller
@RequestMapping("/officers/")
public class OfficerController {

    private final OfficerRepository officerRepository;

    @Autowired
    public OfficerController(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Officer officer) {
        return "add-officer";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("officers", officerRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addOfficer(@Valid Officer officer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-officer";
        }

        officerRepository.save(officer);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Officer officer = officerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid officer Id:" + id));
        model.addAttribute("officer", officer);
        return "update-officer";
    }

    @PostMapping("update/{id}")
    public String updateOfficer(@PathVariable("id") long id, @Valid Officer officer, BindingResult result,
                                           Model model) {
        if (result.hasErrors()) {
            officer.setId(id);
            return "update-officer";
        }

        officerRepository.save(officer);
        model.addAttribute("officers", officerRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteOfficer(@PathVariable("id") long id, Model model) {
        Officer officer = officerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid officer Id:" + id));
        officerRepository.delete(officer);
        model.addAttribute("officers", officerRepository.findAll());
        return "index";
    }
}