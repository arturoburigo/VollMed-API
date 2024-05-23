package med.voll.api.patients;

import med.voll.api.address.AddressData;

public record PatientRegisterData(String name, String email, String phone, String cpf, AddressData address) {
}
