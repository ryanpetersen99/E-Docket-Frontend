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
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.repository.Police.EvidenceTechnicianRepository;


@Controller
@RequestMapping("/evidenceTechnicians/")
public class EvidenceTechnicianController {

    private final EvidenceTechnicianRepository evidenceTechnicianRepository;

    @Autowired
    public EvidenceTechnicianController(EvidenceTechnicianRepository evidenceTechnicianRepository) {
        this.evidenceTechnicianRepository = evidenceTechnicianRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(EvidenceTechnician evidenceTechnician) {
        return "add-evidenceTechnician";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("evidenceTechnicians", evidenceTechnicianRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addEvidenceTechnician(@Valid EvidenceTechnician evidenceTechnician, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-evidenceTechnician";
        }

        evidenceTechnicianRepository.save(evidenceTechnician);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        EvidenceTechnician evidenceTechnician = evidenceTechnicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid evidenceTechnician Id:" + id));
        model.addAttribute("evidenceTechnician", evidenceTechnician);
        return "update-evidenceTechnician";
    }

    @PostMapping("update/{id}")
    public String updateEvidenceTechnician(@PathVariable("id") long id, @Valid EvidenceTechnician evidenceTechnician, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            evidenceTechnician.setId(id);
            return "update-evidenceTechnician";
        }

        evidenceTechnicianRepository.save(evidenceTechnician);
        model.addAttribute("evidenceTechnicians", evidenceTechnicianRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteEvidenceTechnician(@PathVariable("id") long id, Model model) {
        EvidenceTechnician evidenceTechnician = evidenceTechnicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid evidenceTechnician Id:" + id));
        evidenceTechnicianRepository.delete(evidenceTechnician);
        model.addAttribute("evidenceTechnicians", evidenceTechnicianRepository.findAll());
        return "index";
    }
}