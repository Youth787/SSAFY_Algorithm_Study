import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemKinds.size();
        Map<String, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int start = 0, left = 0, right = 0;
        
        while (true) {
            if (map.size() == totalKinds) {
                if (right-left < minLen) {
                    minLen = right-left;
                    start = left;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            } else {
                if (right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }
        return new int[]{start + 1, start + minLen};
    }
}
