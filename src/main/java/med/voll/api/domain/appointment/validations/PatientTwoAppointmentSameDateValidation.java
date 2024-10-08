package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import med.voll.api.domain.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientTwoAppointmentSameDateValidation implements AppointmentValidations {

    @Autowired
    private AppointmentRepository repository;

    public void validate(AppointmentData data) {
        var firstHour = data.date().withHour(7);
        var lastHour = data.date().withHour(18);
        var patientHaveAnotherAppointmentOnSameDate = repository.existsByPatientsIdAndDateBetween(data.idPatient(), firstHour, lastHour);
        if (patientHaveAnotherAppointmentOnSameDate) {
            throw  new ValidationException("There is already an appointment on the same date");
        }
    }
}
