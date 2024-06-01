package med.voll.api.domain.address;

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

    public void updateAddress(AddressData address) {
            if (address.city() != null) {
                this.city = address.city();
            }
            if (address.state() != null) {
                this.state = address.state();
            }
            if (address.zipcode() != null) {
                this.zipcode = address.zipcode();
            }
            if (address.number() != null) {
                this.number = address.number();
            }
            if (address.complement() != null) {
                this.complement = address.complement();
            }
            if (address.county() != null) {
                this.county = address.county();
            }
            if (address.street() != null) {
                this.street = address.street();
            }
        }
}
