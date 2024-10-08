package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import med.voll.api.domain.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicWithAnotherAppointmentSameHourValidation implements  AppointmentValidations {
    @Autowired
    private AppointmentRepository repository;
    public void validate(AppointmentData data) {
        var medicHaveAnotherAppointmentOnSameHour = repository.existsByMedicsIdAndDate(data.idMedic(), data.date());
        if (medicHaveAnotherAppointmentOnSameHour) {
            throw new ValidationException("Medic has another another appointment on same hour");
        }
    }
}
