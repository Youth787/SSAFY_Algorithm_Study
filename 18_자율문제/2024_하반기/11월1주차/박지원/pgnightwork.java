//프로그래머스 야근지수 자바
//heap, pq활용한 정렬

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int a: works) {
            pq.add(a);
        }
        while (n-- > 0) {
            int temp = pq.poll();
            pq.add(temp - 1);
        }
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            if (temp <= 0) continue;
            answer += temp * temp;
        }
        
        return answer;
    }
}
