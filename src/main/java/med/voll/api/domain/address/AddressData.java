package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String street,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String zipcode,
        String number,
        String complement,
        @NotBlank
        String county   ) {
}
