import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String,Integer> nameToIndex = new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            nameToIndex.put(enroll[i],i);
        }
        
        for(int i=0;i<seller.length;i++){
            String currentSeller = seller[i];
            int profit = amount[i]*100;
            
            while(!currentSeller.equals("-")){
                int idx = nameToIndex.get(currentSeller);
                int commission = profit/10;
                
                answer[idx] += profit-commission;
                currentSeller = referral[idx];
                profit = commission;
                
                if(profit<1) break;
            }
        }
        
        return answer;
    }
}
