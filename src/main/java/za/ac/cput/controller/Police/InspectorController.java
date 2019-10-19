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
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.Police.InspectorRepository;


@Controller
@RequestMapping("/inspectors/")
public class InspectorController {

    private final InspectorRepository inspectorRepository;

    @Autowired
    public InspectorController(InspectorRepository inspectorRepository) {
        this.inspectorRepository = inspectorRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Inspector inspector) {
        return "add-inspector";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("inspectors", inspectorRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addInspector(@Valid Inspector inspector, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-inspector";
        }

        inspectorRepository.save(inspector);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Inspector inspector = inspectorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inspector Id:" + id));
        model.addAttribute("inspector", inspector);
        return "update-inspector";
    }

    @PostMapping("update/{id}")
    public String updateInspector(@PathVariable("id") long id, @Valid Inspector inspector, BindingResult result,
                                           Model model) {
        if (result.hasErrors()) {
            inspector.setId(id);
            return "update-inspector";
        }

        inspectorRepository.save(inspector);
        model.addAttribute("inspectors", inspectorRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteInspector(@PathVariable("id") long id, Model model) {
        Inspector inspector = inspectorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inspector Id:" + id));
        inspectorRepository.delete(inspector);
        model.addAttribute("inspectors", inspectorRepository.findAll());
        return "index";
    }
}