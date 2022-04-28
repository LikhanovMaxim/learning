package learning.sharing;

import java.util.Scanner;

/**
 * Вход: температура. скорость ветра
 */
public class WeatherDetector {
    public static void main(String[] args) {
        System.out.println("Hi from Epam");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите температутру на улице: ");
            int degrees = scanner.nextInt();
            System.out.print("Введите скорость ветра: ");
            int wind = scanner.nextInt();
            if (degrees < -10) {
                System.out.println("Надень теплую курту!");
            }
            if (wind > 20) {
                System.out.println("не выходи из дома!");
            }
            if (degrees > 10 && degrees < 20) {
                System.out.println("ух тепло. Бери футболку и шлепки");
                if (wind > 10) {
                    System.out.println("но возьми ветровку, что-то дует");
                } else {
                    System.out.println("возьми солнцезащитные очки");
                }
            }
            System.out.print("Ещё разок? введите 'нет' если хотите выйти: ");
            String answer = scanner.next();
            if (answer.equals("нет")) {
                break;
            }
        }
    }
}
