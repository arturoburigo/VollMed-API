package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.Patients;
import med.voll.api.patients.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

