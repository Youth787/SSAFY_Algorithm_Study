import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<number.length();i++){
            char current = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < current && k>0) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}
