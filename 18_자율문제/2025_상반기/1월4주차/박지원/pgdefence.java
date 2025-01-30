//프로그래머스 디펜스 게임 자바
// 간단한 PQ사용문제

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->  o2 - o1);
        int len = enemy.length;
        int answer = len;
        if (len <= k) return len;
        for (int i = 0; i < len; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                    continue;
                } 
                answer = i;
                break;
            }
        }
        return answer;
    }
}
