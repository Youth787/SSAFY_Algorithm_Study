//프로그래머스 최고의 집합 자바
//그냥,,수학

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int a = s / n;
        if (a == 0) return new int[]{-1};
        int b = s % n;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = a;
        }
        int idx = n - 1;
        while (b-- > 0) {
            answer[idx--]++;
        }

        return answer;
    }
}
