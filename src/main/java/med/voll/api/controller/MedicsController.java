package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.medics.GetAllMedics;
import med.voll.api.medics.Medics;
import med.voll.api.medics.MedicsRegisterData;
import med.voll.api.medics.MedicsRepository;
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
        return repository.findAll(pagination).map(GetAllMedics::new);
    }
}
