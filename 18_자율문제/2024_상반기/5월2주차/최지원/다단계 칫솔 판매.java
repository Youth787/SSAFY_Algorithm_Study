import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String,String> parent = new HashMap<>(); //사람, 추천 관계에 있는 사람
        HashMap<String,Integer> total = new HashMap<>(); //사람, 누적 수익금       
        int[] answer = new int[enroll.length]; //반환할 정답
        
        for(int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        } // (1) 사람별로 누가 초대해줬나 다 저장
        
        for(int i=0; i<seller.length; i++) {
            String now = seller[i];
            int money = amount[i] * 100;
            while (money > 0 && !now.equals("-")) {
                total.put(now, total.getOrDefault(now, 0) + money - (money/10));
                now = parent.get(now); //추천인으로 now 변경
                money /= 10; //다음 경우에게 나눠줄 수 있는 10% 금액 계산
            } //부모까지 수익 10% 분배하는 반복문
        } //모든 판매 기록을 도는 for문
        
        for(int i=0; i<enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}
