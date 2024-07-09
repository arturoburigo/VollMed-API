package med.voll.api.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medics.Specialty;

import java.time.LocalDateTime;

public record AppointmentData(
        Long idMedic,

        @NotNull
        Long idPatient,

        @NotNull
        @Future
        LocalDateTime date,

        Specialty specialty
) {
}
