package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import med.voll.api.domain.patients.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientsActiveValidation implements  AppointmentValidations{
    @Autowired
    PatientsRepository repository;

    public void validate(AppointmentData data){
        var isPatientActive = repository.findActiveById(data.idPatient());
        if (!isPatientActive){
            throw new ValidationException("Patient is not active.");
        }

    }
}
