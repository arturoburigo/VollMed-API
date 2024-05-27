package med.voll.api.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record UpdatePatientData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
