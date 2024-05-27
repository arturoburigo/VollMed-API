package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.medics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/medics")
public class MedicsController {
    @Autowired
    private MedicsRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MedicsRegisterData data){
        repository.save(new Medics(data));
    }
    @GetMapping
    public Page<GetAllMedics> getAllMedics(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(GetAllMedics::new);
    }
    @PutMapping
    @Transactional
    public void updateMedicData(@RequestBody @Valid UpdateMedicData data){
        var medic = repository.getReferenceById(data.id());
        medic.updateMedicData(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.inactivate();
    }


}
