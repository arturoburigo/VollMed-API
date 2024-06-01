package med.voll.api.domain.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record UpdatePatientData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
