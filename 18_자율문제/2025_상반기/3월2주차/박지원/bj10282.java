//백준 해킹 자바
//데이크스트라

import java.io.*;
import java.util.*;

public class Main {
    private static class Computer {
        int num, time;

        public Computer(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    private static int n, d, c, count, total;
    private static boolean[] visited;
    private static int[] dist;
    private static ArrayList<ArrayList<Computer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            list = new ArrayList<>();
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Computer(a, s));
            }
            count = 0;
            total = 0;
            dijkstra();

            sb.append(count + " " + total).append("\n");
        }
        System.out.println(sb.toString());

    }
    private static void dijkstra() {
        PriorityQueue<Computer> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.add(new Computer(c, 0));
        dist[c] = 0;

        while (!q.isEmpty()) {
            Computer now = q.poll();
            if (visited[now.num]) continue;
            total = Math.max(total, now.time);
            count++;
            visited[now.num] = true;
            for (Computer next: list.get(now.num)) {
                if (visited[next.num]) continue;

                int newTime = now.time + next.time;
                if (newTime < dist[next.num]) {
                    dist[next.num] = newTime;
                    q.add(new Computer(next.num, newTime));
                }
            }
        }


    }


}

