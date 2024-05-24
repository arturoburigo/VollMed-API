package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String number;
    private String complement;
    private String county;

    public Address(AddressData address) {
        this.city = address.city();
        this.state = address.state();
        this.zipcode = address.zipcode();
        this.number = address.number();
        this.complement = address.complement();
        this.county = address.county();
        this.street = address.street();
    }
}
