//프로그래머스 셔틀버스 자바
//pq, 문자열

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s: timetable) {
            String[] temp = s.split(":");
            pq.add(Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]));
        }
        int startTime = 9 * 60;
        int lastTime = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pq.isEmpty()) {
                int now = pq.peek();
                if (now <= startTime && total < m) {
                    pq.poll();
                    total++;
                } else break;
                lastTime = now - 1;
            }
            startTime += t;
        }
        if (total < m) lastTime = startTime - t;
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }
}
