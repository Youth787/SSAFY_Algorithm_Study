//프로그래머스 기능개발 자바
//큐

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else q.add((100 - progresses[i]) / speeds[i] + 1);
        }
        int x = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            if (q.peek() <= x) {
                q.poll();
                count++;
            } else {
                x = q.poll();
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
