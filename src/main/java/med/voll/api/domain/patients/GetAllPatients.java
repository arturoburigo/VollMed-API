package med.voll.api.domain.patients;

public record GetAllPatients(Long id, String name, String email, String cpf) {
    public GetAllPatients(Patients patients){
        this(patients.getId(), patients.getName(), patients.getEmail(), patients.getCpf());
    }
}
