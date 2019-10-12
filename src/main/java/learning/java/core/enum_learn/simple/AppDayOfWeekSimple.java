package learning.java.core.enum_learn.simple;

import java.util.Arrays;

public class AppDayOfWeekSimple {

    private DayOfWeek dayOfWeek;

    public AppDayOfWeekSimple() {
        dayOfWeek = DayOfWeek.MONDAY;
    }

    public static void main(String[] args) {
        System.out.println(DayOfWeek.SUNDAY.getClass());

        System.out.println(Arrays.toString(DayOfWeek.values()));
        int sundayIndex = DayOfWeek.SUNDAY.ordinal(); // count from zero
        System.out.println("sundayIndex " + sundayIndex); //6
        System.out.println(DayOfWeek.valueOf("SUNDAY")); //DayOfWeek{title='Воскресенье'}
        AppDayOfWeekSimple app = new AppDayOfWeekSimple();
        app.useEnum();
        app.useEnumInSwitch();
    }

    private void useEnum() {
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)) { //OR dayOfWeek == DayOfWeek.FRIDAY
            System.out.println("Today is Friday " + dayOfWeek.getTitle());
        } else {
            System.out.println("Today is not Friday. Today is " + dayOfWeek.getTitle());
        }
    }

    private void useEnumInSwitch() {
        System.out.println("You can use enum in switch");
        switch (dayOfWeek) {
            case MONDAY:
                System.out.println("Mon " + dayOfWeek.getTitle());
                break;
            case FRIDAY:
                System.out.println("Friday " + dayOfWeek.getTitle());
                break;
            default:
                System.out.println("Default " + dayOfWeek.getTitle());
        }
    }
}
