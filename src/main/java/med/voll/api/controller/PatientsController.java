package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medics.GetAllMedics;
import med.voll.api.patients.GetAllPatients;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.Patients;
import med.voll.api.patients.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    @Autowired
    private PatientsRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegisterData data) {
        repository.save(new Patients(data));
    }

    @GetMapping
    public Page<GetAllPatients> getAllPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(GetAllPatients::new);
    }
}

