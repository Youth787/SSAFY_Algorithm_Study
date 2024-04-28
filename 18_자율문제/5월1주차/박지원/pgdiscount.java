import java.util.*;

//프로그래머스 할인 행사. map사용해서 풀었다. 이번 농은 2번이랑 문제 비슷한듯??
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wanna = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wanna.put(want[i], number[i]);
        }
        HashMap<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            temp.put(discount[i], temp.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 9; i < discount.length; i++) {
            temp.put(discount[i], temp.getOrDefault(discount[i], 0) + 1);
            int count = 0;
            a: for (int j = 0; j < want.length; j++) {
                if (temp.getOrDefault(want[j], 0) < number[j]) {
                    break a;
                } else count++;
            }
            if (count == want.length) answer++;
            temp.put(discount[i - 9], temp.getOrDefault(discount[i - 9], 0) - 1);
            
        }
        return answer;
    }
}
