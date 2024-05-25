package med.voll.api.medics;

public record GetAllMedics(String name, String email, String crm, Specialty specialty, String phone) {
    public GetAllMedics(Medics medics) {
        this(medics.getName(), medics.getEmail(), medics.getCrm(), medics.getSpecialty(), medics.getPhone());
    }
}
