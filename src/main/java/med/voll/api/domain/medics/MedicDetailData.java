package med.voll.api.domain.medics;

import med.voll.api.domain.address.Address;

public record MedicDetailData(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address) {
    public MedicDetailData(Medics medics){
        this(medics.getId(), medics.getName(), medics.getEmail(), medics.getCrm(), medics.getPhone(), medics.getSpecialty(), medics.getAddress());
    }
}
