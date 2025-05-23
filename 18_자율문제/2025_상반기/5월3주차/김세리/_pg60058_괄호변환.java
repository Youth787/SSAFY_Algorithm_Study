import java.util.*;
import java.io.*;

class Solution {
    public String solution(String p) {
        if(p.isEmpty()) return p;
        
        int balance=0, idx=0;
        do{
            if(p.charAt(idx++)=='(') balance++;
            else balance--;
        } while(balance != 0);
        String u = p.substring(0,idx);
        String v = p.substring(idx);
        
        if(isCorrect(u)){
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            
            for(int i=1;i<u.length()-1;i++){
                sb.append(u.charAt(i)=='(' ? ')':'(');
            }
            return sb.toString();
        }
    }
    
    private boolean isCorrect(String s){
        int cnt=0;
        for(char c : s.toCharArray()){
            if(c=='(') cnt++;
            else{
                if(cnt==0) return false;
                cnt--;
            }
        }
        return cnt==0;
    }
}
