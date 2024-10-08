package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentData;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CheckAntencedenceAppointment implements   AppointmentValidations{
    //appointment should be made at least 30 minutes before.
    public void validate(AppointmentData data){
        var appointmentDate = data.date();
        var now = LocalDateTime.now();
        var difference = Duration.between(now, appointmentDate).toMinutes();

        if (difference < 30) {
            throw new ValidationException("Appointmentes should be made at least 30 minutes before.");
        }
    }

}
