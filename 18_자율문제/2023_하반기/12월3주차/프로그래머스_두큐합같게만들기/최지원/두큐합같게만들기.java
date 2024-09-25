import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
  
        Queue <Integer> q1 = new LinkedList <Integer>();
        Queue <Integer> q2 = new LinkedList <Integer>();
        
        long sum1 = 0;//q1 합
        long sum2 = 0;//q2 합
        int cnt = 0;//작업 횟수 
        int answer = -1;//-1로 초기화
        
        for(int n : queue1){
            q1.add(n);
            sum1 += n;
        }
        
        for(int n : queue2){
            q2.add(n);
            sum2 += n;
        }

        while(cnt <= queue1.length * 4){//?.? 큐의 원소들이 뒤바뀌는 모든 경우의 수(두 큐의 길이는 같음)
            if(sum1 > sum2){
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.add(tmp);
            }else if(sum1 < sum2){
                int tmp = q2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                q1.add(tmp);
            }else if(sum1 == sum2){ //두 큐의 원소 합이 같은 상황에 answer 갱신하고 break
                answer = cnt;
                break;
            }
            cnt++; //break 안걸렸다면 작업 횟수 +1
        }
    
        return answer;
    }
}
