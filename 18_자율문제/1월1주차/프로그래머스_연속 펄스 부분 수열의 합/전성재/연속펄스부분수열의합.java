import java.util.*;
class Solution {
    public long solution(int[] sequence) {
       
        long max = 0;
        long min = 0;
        long sum = 0;
        
        for(int i = 0; i < sequence.length; i++){
            if(i % 2 == 0){
                sum += sequence[i] * 1;
                }
            else {
                sum += sequence[i] * -1;
                }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            }
            
          
                
      
        
        
        
        return Math.abs(max - min);
    }
}
