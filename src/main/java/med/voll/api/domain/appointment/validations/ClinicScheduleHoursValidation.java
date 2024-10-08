package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ClinicScheduleHoursValidation implements AppointmentValidations {
    public void validate(AppointmentData data){
        var appointmentDate = data.date();

        var sunday = appointmentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeClinicOpens = appointmentDate.getHour() < 7;
        var beforeClinicCloses = appointmentDate.getHour() > 18;
        if (sunday || beforeClinicOpens || beforeClinicCloses) {
            throw  new ValidationException("Appointment out of clinic schedule");
        }
    }
}
