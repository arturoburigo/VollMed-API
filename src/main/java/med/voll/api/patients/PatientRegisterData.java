package med.voll.api.patients;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record PatientRegisterData(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String cpf,
        @NotNull @Valid
        AddressData address) {
}
