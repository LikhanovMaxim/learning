package learning.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise2Test {


    Exercise2 exercise2 = new Exercise2();

    @Test
    public void zoneIsZeroAndWithoutNight() {
        assertTrue(exercise2.filter(10, 14, 11, 13, 0));
        //нет пересечений
        assertFalse(exercise2.filter(1, 2, 3, 4, 0));
        assertFalse(exercise2.filter(3, 4, 1, 2, 0));
    }


    @Test
    public void zoneIsZeroAndWithoutNightAndOneHourShouldBeTrue() {
        assertTrue(exercise2.filter(1, 2, 1, 3, 0));
        assertTrue(exercise2.filter(1, 2, 1, 2, 0));
        assertTrue(exercise2.filter(1, 2, 0, 2, 0));
    }

    @Test
    public void zoneIsZeroAndWithoutNightAndOneHourShouldBeFalse() {
        assertFalse(exercise2.filter(1, 2, 2, 3, 0));
        assertFalse(exercise2.filter(1, 2, 0, 1, 0));
    }

    // с переходом
//         * Переход
//     * 4) [23, 2) & [1, 2) - true
//             * 6) [23, 0) [0, 1) - false
//             * [20, 8) & [19, 23) - true
    @Test
    public void zoneIsZeroAndNight() {
        assertTrue(exercise2.filter(23, 2, 0, 1, 0));
        assertTrue(exercise2.filter(20, 8, 19, 23, 0));
        assertFalse(exercise2.filter(23, 0, 0, 1, 0));
    }

    //zone=1
    @Test
    public void zoneIsPositive() {
        assertTrue(exercise2.filter(22, 23, 21, 22, 1));
        assertFalse(exercise2.filter(22, 23, 22, 23, 1));
    }

    @Test
    public void zoneIsPositiveAndNightMove() {
        assertTrue(exercise2.filter(0, 1, 22, 23, 2));
        assertTrue(exercise2.filter(0, 1, 22, 23, 2));
    }

    //    zone=-1
    @Test
    public void zoneIsNegative() {
        assertTrue(exercise2.filter(20, 21, 21, 22, -1));
    }
}