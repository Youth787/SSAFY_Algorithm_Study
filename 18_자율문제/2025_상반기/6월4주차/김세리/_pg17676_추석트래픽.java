import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] lines) {
        int N = lines.length;
        double[][] times = new double[N][2];
        double max = 0;
        for(int i=0;i<N;i++){
            String[] parts = lines[i].split(" ");
            String[] timeParts = parts[1].split(":");
            
            double endTime = 
                Integer.parseInt(timeParts[0])*3600
                + Integer.parseInt(timeParts[1])*60
                + Double.parseDouble(timeParts[2]);
            
            double duration = Double.parseDouble(parts[2].replace("s",""));
            double startTime = endTime-duration + 0.001;
            
            times[i][1] = endTime;
            times[i][0] = startTime;
        }
        System.out.println(Arrays.deepToString(times));
        int answer = 0;
        
        for(int i=0;i<N;i++){
            double startWindow = times[i][0];
            double endWindow = times[i][1];
            for(double t : new double[]{startWindow,endWindow}){
                double windowStart = t;
                double windowEnd = t + 1.0;
                int count=0;
                for(int j=0;j<N;j++){
                    if(times[j][0] < windowEnd && times[j][1] >= windowStart){
                        count++;
                    }
                }
                answer = Math.max(answer,count);
            }
        }
        
        
        return answer;
    }
}
