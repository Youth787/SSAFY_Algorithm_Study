import java.util.*;

class Solution {
    public static boolean[] plus;
    public static int n, answer, t;
    public static int[] num;
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        t = target;
        plus = new boolean[n];
        num = numbers.clone();
        combi(0, 0);
        return answer;
    
    }
    public static void combi(int idx, int cnt) {
        if (idx >= n) {
            check();
            return;
        }
        plus[idx] = true;
        combi(idx + 1, cnt + 1);
        plus[idx] = false;
        combi(idx + 1, cnt);
    }
    public static void check() {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (plus[i]) temp += num[i];
            else temp -= num[i];
        }
        if (temp == t) answer++;
    }
}
