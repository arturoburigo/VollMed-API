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
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

}