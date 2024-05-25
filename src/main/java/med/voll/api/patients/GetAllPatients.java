package med.voll.api.patients;

public record GetAllPatients(String name, String email, String cpf) {
    public GetAllPatients(Patients patients){
        this(patients.getName(), patients.getEmail(), patients.getCpf());
    }
}
