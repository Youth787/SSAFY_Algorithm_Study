import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        for (int i = 1; i <= 8; i++) {

            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);

            for (int j = 1; j < i; j++) {
                Set<Integer> s1 = dp.get(j);
                Set<Integer> s2 = dp.get(i - j);
                for (int a : s1) {
                    for (int b : s2) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}
