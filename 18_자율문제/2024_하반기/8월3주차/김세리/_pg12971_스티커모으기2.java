import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;       
        int answer = 0;
        
        if(n==1) answer = sticker[0];
        if(n==2) answer = Math.max(sticker[0],sticker[1]);

        if(n>2){
            // 첫 번째 스티커를 선택한 경우(마지막 스티커는 제외한다)
            int[] dp1 = new int[n];
            dp1[0] = sticker[0];
            dp1[1] = Math.max(sticker[0],sticker[1]);
        
            for(int i=2;i<n-1;i++){
               dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]);
            }
        
            // 첫 번째 스티커를 선택하지 않은 경우(마지막 스티커 선택가능)
            int[] dp2 = new int[n];
            dp2[0] = 0;
            dp2[1] = sticker[1];
        
            for(int i=2;i<n;i++){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
            }
            
            answer = Math.max(dp1[n-2], dp2[n-1]);
        }
        
        
        return answer;
    }
}
