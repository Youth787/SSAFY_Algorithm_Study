//백준 숨바꼭질2 자바
//그래프이론, bfs

import java.io.*;
import java.util.*;

public class Main {
    private static class Time implements Comparable<Time> {
        int time, count;

        public Time(int time, int count) {
            this.time = time;
            this.count = count;
        }

        @Override
        public int compareTo(Time t) {
            return this.count - t.count;
        }
    }
    private static int n, k, answerCount;
    private static int[] time;
    private static int[] move = new int []{-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        time = new int[100001];
        findSister();

        sb.append(time[k]).append("\n").append(answerCount);
        System.out.println(sb);

    }
    private static void findSister() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        if (n == k) {
            answerCount++;
            return;
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) next = now * move[i]; // 순간이동
                else next = now + move[i]; // 걷기

                if (next < 0 || next > 100000 || (time[next] != 0 && time[next] < time[now] + 1 )) continue;
                time[next] = time[now] + 1;
                q.add(next);

                if (next == k) answerCount++;
            }
        }
    }
}
