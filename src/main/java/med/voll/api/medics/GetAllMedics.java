package med.voll.api.medics;

public record GetAllMedics(Long id, String name, String email, String crm, Specialty specialty, String phone) {
    public GetAllMedics(Medics medics) {
        this(medics.getId(),medics.getName(), medics.getEmail(), medics.getCrm(), medics.getSpecialty(), medics.getPhone());
    }
}
