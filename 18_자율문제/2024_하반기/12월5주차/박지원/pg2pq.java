//프로그래머스 이중우선순위큐 자바
//max큐와 min큐 두가지를 활용한 풀이

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxHip = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHip = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (String operation: operations) {
            String order = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            if (order.equals("D")) {
                if (num == 1) {
                    minHip.remove(maxHip.poll());
                } else {
                    maxHip.remove(minHip.poll());
                }
            } else if (order.equals("I")) {
                maxHip.add(num);
                minHip.add(num);
            }
        }
        answer[0] = maxHip.isEmpty() ? 0 : maxHip.poll();
        answer[1] = minHip.isEmpty() ? 0 : minHip.poll();
        return answer;
    }
}
