package learning.patterns.behavioral.strategy;

import learning.patterns.behavioral.strategy.shop.Order;
import learning.patterns.behavioral.strategy.strategies.PayByCreditCard;
import learning.patterns.behavioral.strategy.strategies.PayByPayPal;
import learning.patterns.behavioral.strategy.strategies.PayByYandex;
import learning.patterns.behavioral.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Первый в мире консольный интерет магазин.
 */
public class App {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (orderIsNotClosed()) {

            choseProducts();
            if (strategy == null) {
                chosePaymentByStrategy();
                // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
                // только стратегии знают какие данные им нужны для приёма
                // оплаты.
                order.processOrder(strategy);
            } else {
                System.out.println("You have chose a payment " + strategy.toString());
            }

            if (isEndOrder()) {
                endOrder();
            }
        }
    }

    private static void endOrder() {
        // И наконец, стратегия запускает приём платежа.
        if (strategy.pay(order.getTotalCost())) {
            System.out.println("Payment has been successful.");
        } else {
            System.out.println("FAIL! Please, check your data.");
        }
        order.setClosed();
    }

    private static boolean isEndOrder() throws IOException {
        System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
        String proceed = reader.readLine();
        return proceed.equalsIgnoreCase("P");
    }

    private static void chosePaymentByStrategy() throws IOException {
        System.out.println("Please, select a payment method:" + "\n" +
                "1 - PalPay" + "\n" +
                "2 - Credit Card" + "\n" +
                "3 - Yandex");
        String paymentMethod = reader.readLine();

        // Клиент создаёт различные стратегии на основании
        // пользовательских данных, конфигурации и прочих параметров.
        switch (paymentMethod) {
            case "1":
                strategy = new PayByPayPal();
                break;
            case "2":
                strategy = new PayByCreditCard();
                break;
            case "3":
                strategy = new PayByYandex();
                break;
            default:
                System.out.println("Close this application because I want it!");
        }
    }

    private static boolean orderIsNotClosed() {
        return !order.isClosed();
    }

    private static void choseProducts() throws IOException {
        int cost;
        String continueChoice;
        do {
            System.out.print("Please, select a product:" + "\n" +
                    "1 - Mother board" + "\n" +
                    "2 - CPU" + "\n" +
                    "3 - HDD" + "\n" +
                    "4 - Memory" + "\n");
            int choice = Integer.parseInt(reader.readLine());
            cost = priceOnProducts.get(choice);
            System.out.print("Count: ");
            int count = Integer.parseInt(reader.readLine());
            order.setTotalCost(cost * count);
            System.out.print("Do you wish to continue selecting products? Y/N: ");
            continueChoice = reader.readLine();
        } while (continueChoice.equalsIgnoreCase("Y"));
    }
}