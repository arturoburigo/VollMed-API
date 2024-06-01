package med.voll.api.domain.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Table(name = "patients")
@Entity(name = "Patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patients {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String cpf;
    @Embedded
    private Address address;

    private Boolean active;

    public  Patients(PatientRegisterData data){
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }

    public void updateData(UpdatePatientData data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.phone() != null){
            this.phone = data.phone();
        }
        if (data.address() != null){
            this.address.updateAddress(data.address());
        }
    }

    public void inactivate() {
        this.active = false;
    }
}
