package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.service.Police.implementation.EvidenceTechnicianServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/evidenceTechnician")
public class EvidenceTechnicianController {

    @Autowired
    @Qualifier("EvidenceTechnicianServiceImplementation")
    private EvidenceTechnicianServiceImplementation evidenceTechnicianServiceImplementation;

    @PostMapping("/new")
    public EvidenceTechnician create(@RequestBody EvidenceTechnician create) {

        return evidenceTechnicianServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public EvidenceTechnician findById(@PathVariable String id) {

        EvidenceTechnician read = evidenceTechnicianServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody EvidenceTechnician update) {

        evidenceTechnicianServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        evidenceTechnicianServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<EvidenceTechnician> getAll() {
        return evidenceTechnicianServiceImplementation.getEvidenceTechnicianSet();
    }


}