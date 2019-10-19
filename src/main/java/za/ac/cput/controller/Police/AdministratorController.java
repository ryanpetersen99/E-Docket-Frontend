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
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.repository.Police.AdministratorRepository;


@Controller
@RequestMapping("/administrators/")
public class AdministratorController {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorController(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Administrator administrator) {
        return "add-administrator";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("administrators", administratorRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addAdministrator(@Valid Administrator administrator, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-administrator";
        }

        administratorRepository.save(administrator);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid administrator Id:" + id));
        model.addAttribute("administrator", administrator);
        return "update-administrator";
    }

    @PostMapping("update/{id}")
    public String updateAdministrator(@PathVariable("id") long id, @Valid Administrator administrator, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            administrator.setId(id);
            return "update-administrator";
        }

        administratorRepository.save(administrator);
        model.addAttribute("administrators", administratorRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteAdministrator(@PathVariable("id") long id, Model model) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid administrator Id:" + id));
        administratorRepository.delete(administrator);
        model.addAttribute("administrators", administratorRepository.findAll());
        return "index";
    }
}