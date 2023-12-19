import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        long s1 = 0;
        long total = 0;
        for(int i = 0; i < queue1.length; i++){
            s1 += queue1[i];
            total += queue1[i] + queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if(total % 2 != 0){
            return -1;
        }
        total /= 2;
        
        while(s1 != total){
            if(answer > (queue1.length + queue2.length)+1){
                return -1;

            }
            else if(s1 < total){
                s1 += q2.peek();
                q1.add(q2.poll());
                
            }
            else{
                s1 -= q1.peek();
                q2.add(q1.poll());
                
                
            }
            answer++;
        }
        
        
        return answer;
    }
}
