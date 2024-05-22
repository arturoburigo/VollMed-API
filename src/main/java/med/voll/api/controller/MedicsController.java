package med.voll.api.controller;

import med.voll.api.medics.MedicsRegisterData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/medics")
public class MedicsController {
    @PostMapping
    public void register(@RequestBody MedicsRegisterData json){
        System.out.println(json);
    }
}
