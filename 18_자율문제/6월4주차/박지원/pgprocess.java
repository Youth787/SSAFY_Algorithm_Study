//프로그래머스 프로세스 자바
//자스랑은 또다른느낌.. 자스는 그냥 배열에서 빼고 추가하는게 쉽지만 자바는 그렇지않다
//그래서 pq써서 해결

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int i : priorities) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;

                    if (location == i) {
                        return answer;
                    }
                }
            }
        }


        return answer;
    }
}
