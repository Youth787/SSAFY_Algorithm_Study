import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int w: works) pq.add(w);
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (now != 1) pq.add(now - 1);
            n--;
            if (n == 0) break;
        }
        if (n > 0) answer = 0;
        else {
            while (!pq.isEmpty()) {
                int now = pq.poll();
                answer += now * now;
            }
        }
        return answer;
    }
}
