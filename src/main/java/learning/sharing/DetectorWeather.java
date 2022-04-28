package learning.sharing;

import java.util.Scanner;

/**
 * вход: темпратуру и скорость ветра
 * выход: совет
 */
public class DetectorWeather {
    public static void main(String[] args) {
        System.out.println("hi from Epam!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру на улице: ");
//        while(){
//
//        }
        int degrees = scanner.nextInt();
        System.out.print("Введите скорость ветра: ");
        int wind = scanner.nextInt();
        if (wind < 0 || wind > 100 || degrees < -274 || degrees > 1000) {
            System.out.println("что-то не так с данным, попробуйте ещё раз");
            return;
        }
        if (wind > 20) {
            System.out.println("не выходи из дома!");
        }
        if (degrees < -10) {
            System.out.println("надень зимнюю куртку");
        }
        if (degrees > 10 && degrees < 25) {
            System.out.println("ура каникулы! надень кофту на молнию");
            if (wind >= 10) {
                System.out.println("Лучше штаны, чем шорты");
            } else {
                System.out.println("Отличная погода!");
            }
        }
    }
}
