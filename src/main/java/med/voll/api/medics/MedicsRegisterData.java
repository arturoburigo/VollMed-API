package med.voll.api.medics;

import med.voll.api.address.AddressData;

public record MedicsRegisterData(String name, String email, String crm, Specialty specialty, AddressData address) {
}
