package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
        return repository.findAllByActiveTrue(pagination).map(GetAllPatients::new);
    }

    @PutMapping
    @Transactional
    public void updatePatientData(@Valid @RequestBody UpdatePatientData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactivate();
    }
}

