import java.util.*;

//프로그래머스 큰 수 만들기
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> s = new Stack<>();
        s.push(number.charAt(0));
        int cnt = 0;
        int index = 1;
        char cur = number.charAt(index);
        while (true) {
            while (s.peek() < cur) {
                s.pop();
                cnt++;
                if (cnt == k || s.isEmpty()) break;
            }
            s.push(cur);
            index++;
            if (cnt == k || index >= number.length()) break;
            cur = number.charAt(index);
        }

        if (index < number.length()) {
            for (int i = index; i < number.length(); i++) {
                s.push(number.charAt(i));
            }
        }
        while (cnt < k) {
            s.pop();
            cnt++;
        }
        while (!s.isEmpty()) {
            answer += s.pop();
        } 
        
        StringBuffer sb = new StringBuffer(answer);
        return sb.reverse().toString();
    }
}
