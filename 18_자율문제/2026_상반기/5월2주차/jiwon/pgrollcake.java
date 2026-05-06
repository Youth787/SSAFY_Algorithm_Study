import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = 0; i < topping.length - 1; i++) {
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            
            if (right.get(topping[i]) == 1) right.remove(topping[i]);
            else right.put(topping[i], right.get(topping[i]) - 1);
            
            if (right.size() == left.size()) answer++;
        }
        return answer;
    }
}
