package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record DetailedAppointmentData(Long id, Long idMedic, Long idPatient, LocalDateTime date) {
}
