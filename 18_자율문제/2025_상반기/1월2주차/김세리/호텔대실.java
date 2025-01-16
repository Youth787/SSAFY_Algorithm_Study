import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] bookMinutes = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            bookMinutes[i][0] = Integer.parseInt(book_time[i][0].split(":")[0])*60
                + Integer.parseInt(book_time[i][0].split(":")[1]);
            bookMinutes[i][1] = Integer.parseInt(book_time[i][1].split(":")[0])*60
                + Integer.parseInt(book_time[i][1].split(":")[1]) + 10;
        }
        
        Arrays.sort(bookMinutes, (o1,o2)->{
            return Integer.compare(o1[0],o2[0]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<book_time.length;i++){
            int start = bookMinutes[i][0];
            int end = bookMinutes[i][1];
            
            if(!pq.isEmpty()){
                if(pq.peek()<=start){
                    pq.poll();
                    pq.add(end);
                } else{
                    pq.add(end);
                }
            }else{
                pq.add(end);
            }
        }
        int answer = pq.size();
        return answer;
    }
}
