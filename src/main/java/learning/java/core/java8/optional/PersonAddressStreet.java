package learning.java.core.java8.optional;

import java.util.Optional;

public class PersonAddressStreet {
    private Optional<String> string;

    public Optional<String> getString() {
        return string;
    }

    public void setString(Optional<String> string) {
        this.string = string;
    }
}
