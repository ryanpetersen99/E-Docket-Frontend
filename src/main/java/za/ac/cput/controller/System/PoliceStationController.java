package za.ac.cput.controller.System;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.repository.System.PoliceStationRepository;


@Controller
@RequestMapping("/policeStations/")
public class PoliceStationController {

    private final PoliceStationRepository policeStationRepository;

    @Autowired
    public PoliceStationController(PoliceStationRepository policeStationRepository) {
        this.policeStationRepository = policeStationRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(PoliceStation policeStation) {
        return "add-policeStation";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("policeStations", policeStationRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addPoliceStation(@Valid PoliceStation policeStation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-policeStation";
        }

        policeStationRepository.save(policeStation);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        PoliceStation policeStation = policeStationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid policeStation Id:" + id));
        model.addAttribute("policeStation", policeStation);
        return "update-policeStation";
    }

    @PostMapping("update/{id}")
    public String updatePoliceStation(@PathVariable("id") long id, @Valid PoliceStation policeStation, BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            policeStation.setId(id);
            return "update-policeStation";
        }

        policeStationRepository.save(policeStation);
        model.addAttribute("policeStations", policeStationRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deletePoliceStation(@PathVariable("id") long id, Model model) {
        PoliceStation policeStation = policeStationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid policeStation Id:" + id));
        policeStationRepository.delete(policeStation);
        model.addAttribute("policeStations", policeStationRepository.findAll());
        return "index";
    }
}