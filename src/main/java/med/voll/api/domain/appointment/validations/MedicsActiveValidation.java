package med.voll.api.domain.appointment.validations;

import jakarta.validation.Valid;
import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import med.voll.api.domain.medics.MedicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicsActiveValidation implements AppointmentValidations {
    @Autowired
    private MedicsRepository repository;
    public void validate(AppointmentData data) {
        if (data.idMedic() == null) {
            return;
        }

        var isMedicActive = repository.findActiveById(data.idMedic());
        if (!isMedicActive) {
            throw new ValidationException("Cannot made an appointment with a inactive medic.");
        }
    }
}
