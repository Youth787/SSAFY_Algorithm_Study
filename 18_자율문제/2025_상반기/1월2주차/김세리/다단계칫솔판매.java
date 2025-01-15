import java.util.*;
import java.io.*;

class Solution {
    Map<String, String> parentMap = new HashMap<>();
    Map<String, Integer> profitMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        for(int i=0;i<enroll.length;i++){
            parentMap.put(enroll[i],referral[i]);
            profitMap.put(enroll[i],0);
        }
        
        for(int i=0;i<seller.length;i++){
            distributeProfit(seller[i], amount[i]*100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            answer[i] = profitMap.get(enroll[i]);
        }
        
        return answer;
    }
    private void distributeProfit(String seller, int money){
        while(!seller.equals("-") && money>0){
            int commission = money/10;
            int sellerProfit = money-commission;
            
            profitMap.put(seller,profitMap.get(seller)+sellerProfit);
            seller = parentMap.get(seller);
            money = commission;
        }
    }
}
