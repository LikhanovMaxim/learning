package learning.java.core.java8.streamAPI;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-count-duplicate-elements-arraylist#collectors.tomap
 */
public class StreamAtg {
    public static void main(String[] args) {
        List<Commerce> list = getCommerce();
        System.out.println(list);
        Stream<Object> objectStream = list.stream()
                .map(Commerce::getId);
        Map<Object, Integer> collect1 = getCollect(objectStream);
//        Map<Object, Long> collect2 = getCollect2(objectStream);
        System.out.println(collect1);
//        System.out.println(collect2);
    }

    private static Map<Object, Integer> getCollect(Stream<Object> objectStream) {
        return objectStream.collect(Collectors.toMap(Function.identity(), v->1, Integer::sum));
    }

    private static Map<Object, Long> getCollect2(Stream<Object> objectStream) {
        return objectStream.collect(Collectors.groupingBy(k->k, Collectors.counting()));
    }

    private static List<Commerce> getCommerce() {
        List<Commerce> list = new LinkedList<Commerce>();
        String id = "123";
        list.add(Commerce.builder().id(id).k(2).build());
        list.add(Commerce.builder().id(id).k(2).build());
        list.add(Commerce.builder().id(id).k(3).build());
        list.add(Commerce.builder().id("3333id").k(4).build());
        return list;
    }
}

@Builder
@Data
class Commerce {
    private String id = "123";
    private Integer k;
}
