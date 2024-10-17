import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        // 직은거부터 나오는 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 큰거부터 나오는 우선순위큐
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<operations.length;i++){
            String dir = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);
            
            if(dir.equals("I")){
                pq.add(num);
                pq2.add(num);
            }else{
                if(pq.isEmpty()) continue;
                if(num<0){
                    int tmp = pq.poll();
                    pq2.remove(tmp);
                }else{
                    int tmp = pq2.poll();
                    pq.remove(tmp);
                }
            }
        }
        
        int[] answer = new int[2];
        if(pq.isEmpty()){
            answer[0]=0;
            answer[1]=0;
        } else if(pq.size()==1){
            answer[0] = pq.peek();
            answer[1] = pq.poll();
        } else {
            answer[0] = pq2.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}
