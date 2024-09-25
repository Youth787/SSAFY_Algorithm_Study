import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> benefits = new HashMap<>();
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            benefits.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int price = amount[i] * 100;
            while (!current.equals("-")) {
                if (price < 10) {
                    int p = benefits.get(current);
                    benefits.put(current, p + price);
                    break;
                }
                int p = benefits.get(current);
                int temp = (int) Math.ceil(price * 0.9);
                benefits.put(current, p + temp);
                price -= temp;
                current = parents.get(current);
            }
            
        }
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = benefits.get(enroll[i]);
        }
        
        return answer;
    }
}
