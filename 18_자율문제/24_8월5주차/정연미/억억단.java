import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] divisors = new int[e + 1];
        int[] maxDivisors = new int[e + 1];
        int[] maxDivisorNumber = new int[e + 1];
        
        // 모든 숫자의 약수 개수 계산
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisors[j]++;
            }
        }
       
         // e부터 1까지 순회하며, 가장 많은 약수 개수를 가진 숫자를 기록
        int maxCount = 0;
        int maxCountNumber = 0;
        for (int i = e; i >= 1; i--) {
            if (divisors[i] >= maxCount) {
                maxCount = divisors[i];
                maxCountNumber = i;
            }
            maxDivisors[i] = maxCount;
            maxDivisorNumber[i] = maxCountNumber;
        }
        
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxDivisorNumber[starts[i]];
        }
        
        return answer;
    }
}
