import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String tmp = s.substring(i,i+1);
            if(stack.isEmpty()){
                stack.add(tmp);
            } else{
                if(stack.peek().equals(tmp)){
                    stack.pop();
                }else{
                    stack.add(tmp);
                }
            }
        }
        if(stack.isEmpty()) answer =1;
        else answer =0;

        return answer;
    }
}
