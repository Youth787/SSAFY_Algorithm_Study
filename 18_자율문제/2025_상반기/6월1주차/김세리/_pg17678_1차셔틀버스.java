import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        List<Integer> times = new ArrayList<>();
        for(String time : timetable){
            int hour = Integer.parseInt(time.substring(0,2));
            int min = Integer.parseInt(time.substring(3,5));
            times.add(hour*60 + min);
        }
        
        Collections.sort(times);
        
        int busTime = 9*60;
        int lastTime = 0;
        
        int idx = 0;
        for(int i=0;i<n;i++){
            int capacity=0;
            while(capacity<m && idx<times.size() && times.get(idx)<=busTime){
                lastTime = times.get(idx);
                capacity++;
                idx++;
            }
            // 마지막 셔틀일 때
            if(i==n-1){
                if(capacity==m){
                    lastTime--;
                }
                else {
                    lastTime = busTime;
                }
            }
            busTime +=t;
        }

        String answer = String.format("%02d:%02d", lastTime/60, lastTime%60);
        return answer;
    }
}
