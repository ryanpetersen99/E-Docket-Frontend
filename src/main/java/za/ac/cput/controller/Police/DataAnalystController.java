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
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.repository.Police.DataAnalystRepository;


@Controller
@RequestMapping("/dataAnalysts/")
public class DataAnalystController {

    private final DataAnalystRepository dataAnalystRepository;

    @Autowired
    public DataAnalystController(DataAnalystRepository dataAnalystRepository) {
        this.dataAnalystRepository = dataAnalystRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(DataAnalyst dataAnalyst) {
        return "add-dataAnalyst";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("dataAnalysts", dataAnalystRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addDataAnalyst(@Valid DataAnalyst dataAnalyst, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-dataAnalyst";
        }

        dataAnalystRepository.save(dataAnalyst);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        DataAnalyst dataAnalyst = dataAnalystRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dataAnalyst Id:" + id));
        model.addAttribute("dataAnalyst", dataAnalyst);
        return "update-dataAnalyst";
    }

    @PostMapping("update/{id}")
    public String updateDataAnalyst(@PathVariable("id") long id, @Valid DataAnalyst dataAnalyst, BindingResult result,
                                      Model model) {
        if (result.hasErrors()) {
            dataAnalyst.setId(id);
            return "update-dataAnalyst";
        }

        dataAnalystRepository.save(dataAnalyst);
        model.addAttribute("dataAnalysts", dataAnalystRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteDataAnalyst(@PathVariable("id") long id, Model model) {
        DataAnalyst dataAnalyst = dataAnalystRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dataAnalyst Id:" + id));
        dataAnalystRepository.delete(dataAnalyst);
        model.addAttribute("dataAnalysts", dataAnalystRepository.findAll());
        return "index";
    }
}