package learning.algorithm.cracking;

public class CrackingInterview {

    int pairSumSequence(int n) {/* Ex 2.*/
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    int pairSum(int a, int b) {
        return a + b;
    }

    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int f(int n) {
        count++;
        System.out.println("call f with n=" + n);
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
        //what is complexity O()? see result in test
    }

    //
}
