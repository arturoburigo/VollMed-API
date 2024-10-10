package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patients.GetAllPatients;
import med.voll.api.domain.patients.Patients;
import med.voll.api.domain.patients.PatientsRepository;
import med.voll.api.domain.patients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
@SecurityRequirement(name="bearer-key")
public class PatientsController {
    @Autowired
    private PatientsRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PatientRegisterData data, UriComponentsBuilder uriBuilder) {
        var patient = new Patients(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailData(patient));

    }

    @GetMapping
    public ResponseEntity<Page<GetAllPatients>> getAllPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(GetAllPatients::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatientData(@Valid @RequestBody UpdatePatientData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);

        return ResponseEntity.ok(new PatientDetailData(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.inactivate();

        return ResponseEntity.ok(new PatientDetailData(patient));
    }
}

