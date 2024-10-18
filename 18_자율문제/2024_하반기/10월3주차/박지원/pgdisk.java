//프로그래머스 디스크 컨트롤러 자바
//힙(pq)

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int end = 0;
        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        while (count < jobs.length) {
            while (index < jobs.length && end >= jobs[index][0]) {
                pq.add(jobs[index++]);
            }
            
            if (pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] now = pq.poll();
                answer += now[1] + end - now[0];
                end += now[1];
                count++;
            }
        }
            
        return (int) Math.floor(answer / jobs.length);
    }
}
