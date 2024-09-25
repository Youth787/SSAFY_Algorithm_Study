// 백준 회의실배정 자바
// 끝시간을 기준으로 정렬하는 아이디어를 생각못해서 오래걸렸다...

import java.io.*;
import java.util.*;

public class Main{
    private static class Time {
        int start, end;
        public Time (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private static PriorityQueue<Time> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        } );

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }
        
        int count = 0;
        int prevTime = 0;
        for (int i = 0; i < n; i++) {
            Time now = list.poll();
            if (prevTime <= now.start) {
                prevTime = now.end;
                count++;
            }
        }
        System.out.println(count);
    }
}
