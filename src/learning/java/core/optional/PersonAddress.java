package learning.java.core.optional;

import java.util.Optional;

public class PersonAddress {
    private Optional<String> street;

    private Optional<String> flat;
    private Optional<PersonAddressStreet> personAddressStreet;

    public Optional<String> getStreet() {
        return street;
    }

    public void setStreet(Optional<String> street) {
        this.street = street;
    }

    public Optional<String> getFlat() {
        return flat;
    }

    public void setFlat(Optional<String> flat) {
        this.flat = flat;
    }

    public Optional<PersonAddressStreet> getPersonAddressStreet() {
        return personAddressStreet;
    }

    public void setPersonAddressStreet(Optional<PersonAddressStreet> personAddressStreet) {
        this.personAddressStreet = personAddressStreet;
    }
}
