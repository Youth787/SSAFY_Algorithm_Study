import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        
        long min = 0;
        long max = Long.MAX_VALUE / 100;
        long mid = 0;
        
        while(min<=max){
            long total =0;
            long gold =0;
            long silver =0;
            
            for(int i=0; i<t.length; i++){
                mid = (min+max)/2;
                
                int gg = g[i];
                int ss = s[i];
                int ww = w[i];
                int tt = t[i];
                
                long count = mid / (tt*2);
                if(mid%(tt*2)>=tt) count++;
                
                total += Math.min(gg+ss, count*ww);
                gold += Math.min(gg, count*ww);
                silver += Math.min(ss, count*ww);
            }
             if(a+b<=total && a<=gold && b<=silver){
                answer = mid;
                max = mid-1;
            }else min = mid+1;
        }
        return answer;
    }
}
