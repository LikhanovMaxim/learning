package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.List;

class StepsCountTest {

    //        [{ userId: 1, steps: 1000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 1000 }]
//        # вывод
//        champions = { userIds: [2], steps: 2500 }
    @Test
    public void test1() {
        List<List<Stat>> stat = List.of(
                List.of(new Stat(1, 1000), new Stat(2, 1500)),
                List.of(new Stat(2, 1000)
                ));
        new StepsCount().findChampions(stat);
    }
}