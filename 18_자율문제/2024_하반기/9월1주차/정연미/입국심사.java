import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = 0;
        long max = Integer.MIN_VALUE;
        for(int num : times) if(max<=num) max = num; 
        max = max * n;
        
        while(min<max){
            long mid = (min+max)/2;
            long sum =0;
            for(int time : times) sum += mid/time;
            if(sum>=n) max = mid;
            else min = mid+1;
        }
        
        return max;
    }
}
