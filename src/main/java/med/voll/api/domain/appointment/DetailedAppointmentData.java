package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record DetailedAppointmentData(Long id, Long idMedic, Long idPatient, LocalDateTime date) {

    public DetailedAppointmentData(Appointment appointment) {
        this(appointment.getId(), appointment.getMedics().getId(), appointment.getPatients().getId(), appointment.getDate());
    }
}
