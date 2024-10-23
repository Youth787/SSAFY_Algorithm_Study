import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;
        int completedTask = 0;
        int totalWaitTime = 0;
        
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0],b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1],b[1]);
            }
        });
        
        int jobIndex=0;
        
        while(completedTask < jobs.length){
            while(jobIndex<jobs.length && jobs[jobIndex][0]<=currentTime){
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[jobIndex][0];
            }else{
                int[] nextTask = pq.poll();
                currentTime += nextTask[1];
                totalWaitTime += (currentTime-nextTask[0]);
                completedTask++;
            }
        }
        answer = totalWaitTime/jobs.length;
        return answer;
    }
}
