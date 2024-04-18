import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int len = progresses.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
        }
        int cnt = 0;
        int max = left[0];
        for (int i = 0; i <len; i++) {
            if (left[i] <= max) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                max = left[i];
            }
        }
        
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
