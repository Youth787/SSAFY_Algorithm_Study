import java.io.*;
import java.util.*;

//백준 최소비용구하기 다익스크라
//인접리스트를 활용한 풀이
//아직도 어렵다ㅜㅜ..
class City implements Comparable<City> {

    int end;
    int cost;
    public City (int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(City c) {
        return this.cost - c.cost;
    }

}

public class Main {
    static int n, m;
    static ArrayList<ArrayList<City>> list;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new City(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startPoint, endPoint));

    }

    static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        pq.offer(new City(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            City current = pq.poll();
            int cur = current.end;

            if (!check[cur]) {
                check[cur] = true;

                for (City c: list.get(cur)) {
                    if (!check[c.end] && dist[c.end] > dist[cur] + c.cost) {
                        dist[c.end] = dist[cur] + c.cost;
                        pq.add(new City(c.end, dist[c.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
