package learning.algorithm.array.medium;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {

    /*
    [1,2,3] -sorted
    [3,4] - sorted
    [1,2] - remove all elements in a which has in b
     */
    public List<Integer> task1(int[]a, int[]b){
        List<Integer> res = new ArrayList<>();
        
        return res;
    }

    public List<Integer> task2(int[] a, int[] b){
        List<Integer> r = new ArrayList<>();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int countIntersect = 0;
        for (int i=0; i <a.length; i++) {
            if (a[i]==b[i]) {
                if (!setA.contains(a[i]) || !setB.contains(a[i]) ){
                    countIntersect++;
                }
            } else {
                int first =  (!setA.contains(a[i]) && setB.contains(a[i]) ) ?  1 : 0;
                int second = (!setB.contains(b[i]) && setA.contains(b[i])) ?  1 : 0;
                countIntersect += first + second;
            }
            setA.add(a[i]);
            setB.add(b[i]);
            r.add(countIntersect);
        }
        return r;
    }
}
/*
m_1 = 0
m_2 = 1
m_3 == 1
m_4 = 2

a = [3,4,1,6]
b = [4,4,6,6]
r = [0,1,1,2]
a.size() == b.size() == n

m_k = кол-во чисел, которые встречаются в обоих префиксах длины k
посчитать [m_1, m_2, .., m_n]

1) bruteforce

2)

a = [3,4,1,6]
b = [4,7,6,6]
setA =  3
setB =  4


setAB =
i=0 -> 3,4
i=1 -> + setDelta(4,7) 3,4,7

intesect = {} {}
fori()
    intersect setA & setB .size()


time O(N * ??)
space O(2*N)

3)
setAB =
i=0 -> 3,4
i=1 -> + setDelta(4,7) 3,4,7
i=2

intesect
count = 0
fori()
    intersect setAB & setDelta{a[i], b[i]}


time O(N * ??)
space O(2*N)

4)

setA + a[i]
setB + b[i]

q + ??

1)
[3,4]
[3,5]
r=1
2)
[1, 2]
[3, 4]
r=0
3)
[1, 2]
[2, 3]
r=0
r=1
setA 1
setB 2
4)
[1, 2]
[2, 1]
r=0
r=2
5)
[]
[]

setA =  3
setB =  4
countIntersect = 0
fori()
    if (a[i]==b[i]) {
        count++;
        setA.put(a[i]);
        setB.put(b[i]);
    } else {
        first = a[i].contain(setB) if yes 1 else 0
        second = b[i].contain(setA) if yes 1 else 0
        count+= first + second;
        setA.put(a[i]);
        setB.put(b[i]);
    }
    res[i] = count;

    // count+= first + second;
    // setA.put(a[i])
    // setB.put(b[i])
    // res[i] = count;

[2,2,2,2]
[2,2,2,2]
[1,1,1,1]


2)
[1, 2]
[3, 4]
r=0

[2,2,2,2]
[2,1,1,1]

[2,2]
[1,2]

public List<Integer> task2(int[] a, int[] b){
    List<Integer> r = new ArrayList<>();
    Set<Integer> setA = new HashSet<>();
    Set<Integer> setB = new HashSet<>();
    int countIntersect = 0;
    for (int i=0; i <a.size; i++) {
        if (a[i]==b[i]) {
            if (!setA.contains(a[i]) || !setB.contains(a[i]) ){
                count++;
            }
        } else {
            int first =  (!setA.contains(a[i]) && setB.contains(a[i]) ) ?  1 : 0;
            int second = (!setB.contains(b[i]) && setA.contains(b[i])) ?  1 : 0;
            count += first + second;
        }
        setA.put(a[i]);
        setB.put(b[i]);
        r.add(count);
    }
    return r;
}
 */