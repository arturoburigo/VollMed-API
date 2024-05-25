package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.medics.Medics;
import med.voll.api.medics.MedicsRegisterData;
import med.voll.api.medics.MedicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
