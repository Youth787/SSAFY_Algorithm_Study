import java.util.*;

//프로그래머스 롤케이크 자르기 map
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> left = new HashMap<>(); // 형
        Map<Integer, Integer> right = new HashMap<>(); // 동생
        
        for (int e : topping) {
            right.put(e, right.getOrDefault(e, 0) + 1);
        }
        
        for (int e : topping) {
            left.put(e, left.getOrDefault(e, 0) + 1);
            
            if (right.get(e) - 1 == 0)
               right.remove(e);
            else
                right.put(e, right.get(e) - 1);  
            
            if (left.size() == right.size())
                answer++;
        }

        return answer;
    }
  
}


