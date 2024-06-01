package med.voll.api.domain.medics;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record UpdateMedicData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
