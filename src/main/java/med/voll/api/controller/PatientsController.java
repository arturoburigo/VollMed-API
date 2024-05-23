package med.voll.api.controller;

import med.voll.api.patients.PatientRegisterData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    @PostMapping
    public void register(@RequestBody PatientRegisterData json) {
        System.out.println(json);
    }
}

