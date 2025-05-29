package learning.algorithm.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindOneDiffTest {

    FindOneDiff findOneDiff = new FindOneDiff();

    @Test
    void shouldDelete() {
        assertTrue(findOneDiff.findOneDiff("ab", "a"));
    }
    // Примеры тестовых сценариев:
//   first = "a", second = "b" -> true
//   first = "ab", second = "b" -> true
//        "aaa"   "baaa" |  "aaa" "abaa"
//        "aac" "baaa" -
//   first = "ab", second = "cb" -> true
//   first = "ab", second = "ba" -> false
    @Test
    void shouldChange() {
        assertTrue(findOneDiff.findOneDiff("a", "b"));
        assertTrue(findOneDiff.findOneDiff("ab", "cb"));
    }

    @Test
    void shouldDelete2() {
        assertFalse(findOneDiff.findOneDiff("ab", "ba"));
        assertFalse(findOneDiff.findOneDiff("a", "aaa"));
        assertFalse(findOneDiff.findOneDiff("aa", "acc"));
    }
}