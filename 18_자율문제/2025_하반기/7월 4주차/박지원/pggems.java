import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int cnt = new HashSet<>(Arrays.asList(gems)).size();
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
    
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (map.size() == cnt && len > (i - start)) {
                len = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }

        return answer;
    }

}
