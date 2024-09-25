import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i=0;i<s.length;i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int count110 = 0;

            // 110 문자열 제거
            for (int j=0;j<str.length();j++) {
                stack.push(str.charAt(j));

                // 스택의 마지막 3글자가 "110"일 경우
                if (stack.size() >= 3) {
                    char third = stack.pop();
                    char second = stack.pop();
                    char first = stack.pop();

                    if (first=='1' && second=='1' && third=='0') {
                        count110++;
                    } else {
                        stack.push(first);
                        stack.push(second);
                        stack.push(third);
                    }
                }
            }

            // stack에 남은 문자열을 String으로 변환
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }

            String remainingString = sb.toString();
            int insertPos = remainingString.lastIndexOf('0') + 1;

            // count110만큼 "110"을 삽입
            StringBuilder result = new StringBuilder();
            result.append(remainingString.substring(0, insertPos));
            for (int j=0;j<count110;j++) {
                result.append("110");
            }
            result.append(remainingString.substring(insertPos));

            answer[i] = result.toString();
        }

        return answer;
    }
}
