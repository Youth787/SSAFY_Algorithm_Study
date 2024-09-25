import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> pmap = new HashMap<>(); // <me, parent>
        Map<String, Integer> mymap = new HashMap<>(); // <me, my order>
        
        for(int i = 0; i < enroll.length; i++){
            pmap.put(enroll[i], referral[i]);
            mymap.put(enroll[i], i);
        }
        
        for(int i=0; i<seller.length; i++){
            String now = seller[i];
            int profit = 100 * amount[i];
            
            while(!now.equals("-")){
                int parentprofit = profit / 10; // 부모한테 줄 수익
                int myprofit = profit - parentprofit; // 내가 가져갈 수익
                
                
                answer[mymap.get(now)] += myprofit;
                
                // now를 부모로 이동
                now = pmap.get(now);
                profit = parentprofit;
                
                // 10%의 금액이 1원 미만인 경우 break
                if (profit < 1) {
                    break;
                }
            }
            
        }
        
        return answer;
    }
}
