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
        
        int busTime = 9*60; // 셔틀 시작 시간
        int lastTime = 0; // 마지막 탑승 가능한 시간
        
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
                // 정원이 다 찼다면 마지막 사람보다 먼저 와야함.
                if(capacity==m){
                    lastTime--;
                }
                // 자리 남으면 셔틀 시간에 맞춰타면 됨.
                else {
                    lastTime = busTime;
                }
            }
            // 다음 셔틀 시간
            busTime +=t;
        }
        // 시간을 형식에 맞춰 작성
        String answer = String.format("%02d:%02d", lastTime/60, lastTime%60);
        return answer;
    }
}
