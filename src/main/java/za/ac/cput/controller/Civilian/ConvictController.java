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
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.repository.Civilian.ConvictRepository;


@Controller
@RequestMapping("/convicts/")
public class ConvictController {

    private final ConvictRepository convictRepository;

    @Autowired
    public ConvictController(ConvictRepository convictRepository) {
        this.convictRepository = convictRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Convict convict) {
        return "convict/add-convict";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("convicts", convictRepository.findAll());
        return "convict/convict";
    }

    @PostMapping("add")
    public String addConvict(@Valid Convict convict, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "convict/add-convict";
        }

        convictRepository.save(convict);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Convict convict = convictRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid convict Id:" + id));
        model.addAttribute("convict", convict);
        return "convict/update-convict";
    }

    @PostMapping("update/{id}")
    public String updateConvict(@PathVariable("id") long id, @Valid Convict convict, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            convict.setId(id);
            return "convict/update-convict";
        }

        convictRepository.save(convict);
        model.addAttribute("convicts", convictRepository.findAll());
        return "convict/convict";
    }

    @GetMapping("delete/{id}")
    public String deleteConvict(@PathVariable("id") long id, Model model) {
        Convict convict = convictRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid convict Id:" + id));
        convictRepository.delete(convict);
        model.addAttribute("convicts", convictRepository.findAll());
        return "convict/convict";
    }
}