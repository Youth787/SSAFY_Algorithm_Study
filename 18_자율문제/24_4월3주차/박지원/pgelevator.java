import java.util.*;

//마법의 엘리베이터 프로그래머스 
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int temp = storey;
        while (temp > 0) {
            int per = temp % 10;
            temp /= 10;
            if (per < 5) answer += per;
            else if (per > 5) {
                answer += 10 - per;
                temp++;
            } else {
                if (temp % 10 >= 5) {
                    answer += 10 - per;
                    temp++;
                } else {
                    answer += per;
                }
            }
            
        }
        return answer;
    }
}
