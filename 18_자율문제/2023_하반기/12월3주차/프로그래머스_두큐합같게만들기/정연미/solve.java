package Algo_스터디.Dec_3주차;

import java.util.*;

class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 =0;
        long sum2 =0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        if((sum1+sum2)%2!=0) return -1;
        long half = (sum1+sum2)/2;

        int cnt =0;
        while(sum1!=sum2){
            if(cnt>(queue1.length+queue2.length)*2) return -1;
            if(sum1>half) {
                sum1 -=q1.peek();
                sum2 +=q1.peek();
                q2.add(q1.poll());
            }
            else {
                sum1 +=q2.peek();
                sum2 -=q2.peek();
                q1.add(q2.poll());
            }
            cnt++;
        }
        return cnt;
    }
}