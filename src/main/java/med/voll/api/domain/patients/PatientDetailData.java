package med.voll.api.domain.patients;

import med.voll.api.domain.address.Address;

public record PatientDetailData(Long id, String name, String phone, String cpf, Address address) {
    public PatientDetailData(Patients patients){
        this(patients.getId(), patients.getName(), patients.getPhone(), patients.getCpf(), patients.getAddress());
    }
}
