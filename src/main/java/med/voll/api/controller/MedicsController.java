package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medics.GetAllMedics;
import med.voll.api.domain.medics.Medics;
import med.voll.api.domain.medics.MedicsRepository;
import med.voll.api.domain.medics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/medics")
public class MedicsController {
    @Autowired
    private MedicsRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid MedicsRegisterData data, UriComponentsBuilder uriBuilder){
        var medic = new Medics(data);
        repository.save(medic);
        var uri = uriBuilder.path("/medics/{id}").buildAndExpand(medic.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicDetailData(medic));
    }

    @GetMapping
    public ResponseEntity<Page<GetAllMedics>> getAllMedics(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var page = repository.findAllByActiveTrue(pagination).map(GetAllMedics::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMedicData(@RequestBody @Valid UpdateMedicData data){
        var medic = repository.getReferenceById(data.id());
        medic.updateMedicData(data);

        return ResponseEntity.ok(new MedicDetailData(medic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.inactivate();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDetailData> getMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        return ResponseEntity.ok(new MedicDetailData(medic));
    }


}
