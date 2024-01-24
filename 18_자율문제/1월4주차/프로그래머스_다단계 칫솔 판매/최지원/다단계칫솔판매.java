import java.util.Map;
import java.util.HashMap;
/*
 * 민호 center, 피라미드 구조
 * 이익 9:1 본인:추천인
 * 10% 계산은 원에서 끊고, 1원 미만이 나오면 본인이 가짐
 *
 * ex)
 * [1단계]
 * young (1200의 90% : 10%) => edward (120의 90% : 10%) => mary (12의 90% : 10%) => center (1)
 * [2단계]
 * john (400의 90% : 10%) => center (40)
 * [3단계]
 * tod (200의 90% : 10%) => jaimie (20의 90% : 10%) => mary (2) *원단위라 끝
 * [...]
 * */

class Solution {
    static Map<String,String> recom = new HashMap<>(); //판매원 피라미드 구조
    static Map<String,Integer> profit = new HashMap<>();
    //enroll  판매원 이름, referral 추천자, seller 판매원, 판매 수량(1개당 100원)
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //먼저 판매원 피라미드 구조 처리: 인접 리스트? 근데 그러려면 수익 계산할 때 추천인 찾을때 위로 올라가면서 찾기가 더 복잡하...그럼 반대로 판매원 밑에 추천인을 넣어주면 되나.몰라
        //enroll에 민호는 없음.        
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++) {
            recom.put(enroll[i], referral[i]);
        } //한 사람당 추천인은 1명(중복x) => key값이 판매원, value 값이 추천인
        
        //판매 시 수익 분배 진행 메서드(판매기록에서 한사람씩 분배 파악)
        for(int i=0; i<seller.length; i++) {
            process(seller[i], amount[i] * 100); //개당 100원
        }
        
        for(int i=0; i<enroll.length; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    } //Solution
      
    static void process(String name, int total) {
        if (name.equals("-") || total == 0) {
            return;
        } 
        profit.put(name, profit.getOrDefault(name, 0) + total - total / 10);
        process(recom.get(name), total / 10);
    } //process
} //class
