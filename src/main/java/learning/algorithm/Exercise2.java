package learning.algorithm;

/**
 * You have two time intervals:
 * [start1, finish1) - in UTC timezone
 * [start2, finish2) - in user timezone
 * zone - user timezone
 * All times are presented as 'hours', without minutes
 */
public class Exercise2 {
    /**
     * @param start1  0..23 - start hour of first interval
     * @param finish1 0..23 - finish hour of first interval
     * @param start2  0..23 - start hour of second interval
     * @param finish2 0..23 - finish hour of second interval
     *                start2 < finish2
     * @param zone    -12..12
     * @return TRUE when [start1,finish1) intersects with [start2, finish2) in given timezone
     * zone = 0
     */
    public boolean filter(int start1, int finish1, // <= UTC
                          int start2, int finish2, int zone) {
        //change & shift zone for first interval
        zone = -zone;
        start1 = (24 + start1 + zone) % 24;
        finish1 = (24 + finish1 + zone) % 24;
        System.out.println("zone: " + zone);
        System.out.println(start1 + " " + finish1);
        if (start1 > finish1) {
            if (include(0, finish1, start2, finish2)) return true;
            if (include(start1, 24, start2, finish2)) return true;
            return false;
        }
        // без сдвигов
        return include(start1, finish1, start2, finish2);
    }

    /**
     * Пересечение двух отрезков
     * [a1, a2) , [b1, b2) => b1 < a2 && a1 < b2
     * max(a1, b1) < min(a2, b2)
     *
     * @param start1
     * @param finish1
     * @param start2
     * @param finish2
     * @return
     */
    private static boolean include(int start1, int finish1, int start2, int finish2) {
        return start2 < finish1 && start1 < finish2;
//        return (start2 < finish1 && start2 >= start1) || (finish2 >= start1 && finish2 < finish1);
    }

}

