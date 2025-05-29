package learning.algorithm.array;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepsCount {
    /*

    2) Second idea:
    usersInGame = Set<Int id>
    Map<Integer-Id user, Integer-sumStep>.

    foreach stat[0]
        usersInGame.put(id)

    fori statistics
        foreach
            if(userInGame.contains(id))
                map.id+=steps. //init.steps=0;
                map.id.countDay ++;
            usersInDay.put(id)
        intersect(usersInGame, usersInDay)
    for map
        findMax
    for map
        if findMax
            sout
     time O(N*M+M+M) = O(N*M)
     space O(M + M) = O (M)

     3) without space
     sorting by userId
     fori=1 stat
        for each user
            in previous(i-1) has userId?
                add to current steps +=
            else
                remove or set -1
     space O(1)
     time O(sort N * MlogM + N*M)
     */
    //Условие задачи
//Мы любим проводить соревнования, — недавно мы устроили чемпионат по шагам. И вот настало время подводить итоги!
//
//Необходимо определить userIds участников, которые прошли наибольшее количество шагов steps за все дни, не пропустив ни одного дня соревнований.
//
//        Пример
//# Пример 1
//        # ввод day=N
//statistics = [
//        [{ userId: 1, steps: 1000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 1000 }]
//        ]
//
//        # вывод
//        champions = { userIds: [2], steps: 2500 }
//
//        # Пример 2
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }]
//        ]
//
//        # вывод
//        champions = { userIds: [1, 2], steps: 5500 }
//
//        # Пример 3
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 2, steps: 1000 }, { userId: 1, steps: 2000 }]
//        ]
//
//        # Пример 4
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 1, steps: 2000 }]
//        ]
//champions = { userIds: [], steps: 0 }
//
//        # Пример 5
//statistics = []
//champions = { userIds: [], steps: 0 }
//
//        # Пример 6
//statistics = [
//        [{ userId: 1, steps: 2000 }, { userId: 2, steps: 1500 }],
//        [{ userId: 2, steps: 4000 }, { userId: 1, steps: 3500 }],
//        [{ userId: 2, steps: 1000 }]
//        [{ userId: 1, steps: 2000 }]
//        ]
//champions = { userIds: [], steps: 0 }
//

    public static void main(String[] args) {
//        List<List<Stat>> stat = new ArrayList<>();
//        Stat stat1 = new Stat(2, 2000);
//        Stat stat2 = new Stat(1, 1000);
//        stat.add(new ArrayList<>({stat2, stat1}));
//        findChampions(stat);
    }

    /*
            1) idea:
        Map<Integer-Id user, Integer-sumStep>.
        Map<Integer-Id user, Integer-countDay>.

        fori statistics
        foreach
                map.id+=steps. //init.steps=0;
                map.id.countDay ++;
        for map
            if (countDay == statistic.length)
                findMax
            else
                step = -1
                for map
            if findMax
                sout
        time O(N*M+M+M) = O(N*M)
        space O(M + M) = O (M)

     */
    public void findChampions(List<List<Stat>> stat) {
        Map<Integer, Integer> steps = new HashMap<>();
        Map<Integer, Integer> days = new HashMap<>();
        for (List<Stat> stats : stat) {
            for (Stat cur : stats) {
                steps.put(cur.userId,
                        steps.getOrDefault(cur.userId, 0) + cur.steps);
                days.put(cur.userId,
                        days.getOrDefault(cur.userId, 0) + 1);
            }
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e : steps.entrySet()) {
            Integer countDays = days.get(e.getKey());
            if (countDays == stat.size()) {
                max = Math.max(max, e.getValue());
            } else {
                steps.put(e.getKey(), -1);
            }
        }
        for (Map.Entry<Integer, Integer> e : steps.entrySet()) {
            if (e.getValue() == max) {
                System.out.println("res " + e.getKey() + ". steps: " + e.getValue());
            }
        }
    }


}

class Stat {
    Integer userId;
    Integer steps;

    public Stat(Integer userId, Integer steps) {
        this.userId = userId;
        this.steps = steps;
    }
}
