import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.StringTokenizer;

//특정 거리의 도시 찾기 백준 18352
//이런.. bfs문제 연습좀 해야겠따.....
class City implements Comparable<City> {
    int num;
    int dist;
    public City(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
    @Override
    public int compareTo(City c) {
        return dist - c.dist;
    }
}
public class Main {
    static int n, m, k, x;
    static ArrayList<City>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(new City(b, 1));
        }

        bfs(x);
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
                flag = true;
            }
        }

        if (!flag) System.out.println(-1);
        else System.out.print(sb);


    }
    static void bfs (int now) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(now, 0));
        dist[now] = 0;
        boolean[] visit = new boolean[n + 1];
        while (!pq.isEmpty()) {
            City c = pq.poll();
            if (visit[c.num]) continue;
            visit[c.num] = true;
            for (City next: list[c.num]) {
                if (!visit[next.num] && dist[next.num] > (next.dist + dist[c.num])) {
                    dist[next.num] = dist[c.num] + next.dist;
                    pq.add(new City(next.num, dist[next.num]));
                }
            }
        }
    }
}
