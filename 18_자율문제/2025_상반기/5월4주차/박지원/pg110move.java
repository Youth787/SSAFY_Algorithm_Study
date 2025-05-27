//프로그래머스 110 옮기기 자바
//구현,, 다시봐도 너무 어려운문제,, 
//110갯수 한번에 찾고, 들어갈 위치(0뒤나 맨앞)에 한꺼번에 넣어준다는 아이디어를 떠올리기가 조금 어렵다 ㅠ

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }
        return answer;
    }
    private static String solve(String s) {
        int cnt110 = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            
            if (stack.size() >= 3) {
                
                char first = stack.peek();
                if (first != '0') continue;
                first = stack.pop();
                char second = stack.peek();
                if (second != '1') {
                    stack.push(first);
                    continue;
                }
                second = stack.pop();
                char third = stack.peek();
                if (third != '1') {
                    stack.push(second);
                    stack.push(first);
                    continue;
                }
                third = stack.pop();
                cnt110++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int pos = stack.size();
        boolean flag = false;
        
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            if (!flag && pop == '1') pos--;
            if (pop == '0') flag = true;
            sb.insert(0, pop);
        }
        
        String fix = "";
        for (int i = 0; i < cnt110; i++) {
            sb.insert(pos, "110");
        }
        return sb.toString();
    }
}
