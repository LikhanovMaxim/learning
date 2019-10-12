package learning.patterns.behavioral.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByYandex implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private boolean signedIn;
    private static final Map<String, String> YANDEX = new HashMap<>();

    static {
        YANDEX.put("amanda1985", "amanda@yandex.ru");
        YANDEX.put("qwerty", "john@yandex.ru");
    }


    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using Yandex.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the email: ");
            String email = READER.readLine();
            System.out.print("Enter the password: ");
            String password = READER.readLine();
            if (checkInYandex(email, password)) {
                System.out.println("Data verification has been successful.");
            } else {
                System.out.println("Wrong email or password!");
            }
            ;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkInYandex(String email, String password) {
        setSignedIn(email.equals(YANDEX.get(password)));
        return signedIn;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
