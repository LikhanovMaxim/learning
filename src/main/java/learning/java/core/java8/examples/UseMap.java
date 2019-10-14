package learning.java.core.java8.examples;

import java.util.HashMap;
import java.util.Map;

public class UseMap {
    public static void main(String[] args) {
        Map<String, Integer> pageVisits = new HashMap<>();

        String page = "https://agiledeveloper.com";

        incrementPageVisit(pageVisits, page);
        incrementPageVisit(pageVisits, page);
        incrementPageVisit2(pageVisits, page);
        System.out.println(pageVisits.get(page));
    }

    //Imperative
    public static void incrementPageVisit(Map<String, Integer> pageVisits, String page) {
        if(!pageVisits.containsKey(page)) {
            pageVisits.put(page, 0);
        }

        pageVisits.put(page, pageVisits.get(page) + 1);
    }


    public static void incrementPageVisit2(Map<String, Integer> pageVisits, String page) {
        pageVisits.merge(page, 1, (oldValue, value) -> oldValue + value);
        //TODO BiFunction
    }


}
