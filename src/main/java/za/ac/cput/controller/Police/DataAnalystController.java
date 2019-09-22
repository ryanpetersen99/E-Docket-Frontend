package za.ac.cput.controller.Police;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.service.Police.implementation.DataAnalystServiceImplementation;

import java.util.Set;

@RestController
@RequestMapping("/dataAnalyst")
public class DataAnalystController {

    @Autowired
    @Qualifier("DataAnalystServiceImplementation")
    private DataAnalystServiceImplementation dataAnalystServiceImplementation;

    @PostMapping("/new")
    public DataAnalyst create(@RequestBody DataAnalyst create) {

        return dataAnalystServiceImplementation.create(create);
    }

    @GetMapping(path = "/find/{id}")
    public DataAnalyst findById(@PathVariable String id) {

        DataAnalyst read = dataAnalystServiceImplementation.read(id);
        return read;
    }

    @PutMapping("/update")
    public void update(@RequestBody DataAnalyst update) {

        dataAnalystServiceImplementation.update(update);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        dataAnalystServiceImplementation.delete(id);
    }

    @GetMapping("/getAll")
    public Set<DataAnalyst> getAll() {
        return dataAnalystServiceImplementation.getDataAnalystSet();
    }


}