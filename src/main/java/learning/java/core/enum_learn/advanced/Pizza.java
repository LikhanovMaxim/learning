package learning.java.core.enum_learn.advanced;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.baeldung.com/a-guide-to-java-enums
 */
public class Pizza {

    public Pizza() {
    }

    public Pizza(PizzaStatus initStatus) {
        status = initStatus;
    }

    private PizzaStatus status;

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public int printTimeToDeliver() {
        int timeToDelivery = this.getStatus().getTimeToDelivery();
        System.out.println("Time to delivery is " + timeToDelivery);
        return timeToDelivery;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }


    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pzList) {
        EnumMap<PizzaStatus, List<Pizza>> map = pzList.stream()
                .collect(Collectors.groupingBy(Pizza::getStatus,
                        () -> new EnumMap<>(PizzaStatus.class),
                        Collectors.toList()));
        return map;
    }
}