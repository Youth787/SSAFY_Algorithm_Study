import java.util.*;
import java.io.*;

class Solution {
    public int solution(int storey) {
        int answer =0;
        
        while(storey > 0){
            
            int digit = storey % 10;
            
            if(digit > 5){
                answer += (10-digit);
                storey += 10;
            } else if(digit<5){
                answer += digit;
            } else{
                int next = (storey/10)%10;
                if(next>=5){
                    answer += 10-digit;
                    storey += 10;
                }else{
                    answer += digit;
                }
            }
            storey /= 10;
        }
        
        return answer;
    }
}
