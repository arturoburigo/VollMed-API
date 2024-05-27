package med.voll.api.medics;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "medics")
@Entity(name = "Medics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medics {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active;

    public Medics(MedicsRegisterData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.phone = data.phone();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateMedicData(UpdateMedicData data) {
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