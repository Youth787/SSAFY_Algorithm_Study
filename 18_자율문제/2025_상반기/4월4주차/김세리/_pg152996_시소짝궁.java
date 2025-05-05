import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        Arrays.sort(weights);

        for (int weight : weights) {
            // 가능한 비율 조합 (1:1, 2:3, 2:4, 3:4)
            long w = weight;
            long[] ratios = {
                w * 1,
                w * 2 / 3 * 1L,  // 2:3
                w * 2 / 4 * 1L,  // 2:4
                w * 3 / 4 * 1L   // 3:4
            };

            // 확인 순서: 현재 weight와 짝이 되는 weight가 이전에 나왔는지 확인
            if (w * 1 % 1 == 0 && map.containsKey(w * 1)) answer += map.get(w * 1);
            if (w * 2 % 3 == 0 && map.containsKey(w * 2 / 3)) answer += map.get(w * 2 / 3);
            if (w * 2 % 4 == 0 && map.containsKey(w * 2 / 4)) answer += map.get(w * 2 / 4);
            if (w * 3 % 4 == 0 && map.containsKey(w * 3 / 4)) answer += map.get(w * 3 / 4);

            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        return answer;
    }
}
