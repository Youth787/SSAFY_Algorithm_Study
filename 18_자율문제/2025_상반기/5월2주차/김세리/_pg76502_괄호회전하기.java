import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            String a = s.substring(i)+s.substring(0,i);
            if(isValid(a)){
                answer++;
            }
        }
        return answer;
    }//main
    
    private boolean isValid(String a){
        Stack<Character> stack = new Stack<>();
        for(char c: a.toCharArray()){
            if(c =='('||c=='{'||c=='[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((top=='('&&c!=')')||(top=='{'&&c!='}')||(top=='['&&c!=']')) return false;
            }
        }
        return stack.isEmpty();
    }//isValid
}
