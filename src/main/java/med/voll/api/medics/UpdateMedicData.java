package med.voll.api.medics;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record UpdateMedicData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
