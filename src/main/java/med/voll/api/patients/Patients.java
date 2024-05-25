package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

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

    public  Patients(PatientRegisterData data){
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }
}
