//프로그래머스 괄호 변환 자바
//문자열, 구현, dfs, 재밋따

import java.util.*;

class Solution {
    public String solution(String p) {       
        String answer = dfs(p);
        return answer;
    }
    private static String dfs(String p) {
        if (p.length() == 0) return "";
        if (isRight(p)) return p;
        
        int cntFront = 0;
        int cntBack = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            u += c;
            if (c == '(') cntFront++;
            else cntBack++;
            if (cntFront == cntBack) {
                for (int j = i + 1; j < p.length(); j++) {
                        v += p.charAt(j);
                }    
                if (isRight(u)) {  
                    return u + dfs(v);
                } else {
                    String temp = "(";  
                    temp += dfs(v) + ")";
                    for (int j = 1; j < u.length() - 1; j++) {
                        if (u.charAt(j) == '(') temp += ')';
                        else temp += '(';
                    }
    
                    return temp;
                }
            }
            
        }
        return p;
    }
    private static boolean isRight(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if (temp == ')') return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}

