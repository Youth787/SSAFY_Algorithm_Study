import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

//백준 파티 다익스트라..넘어려워용
class Route implements Comparable<Route> {
    int to;
    int time;

    public Route(int to, int time) {
        this.to = to;
        this.time = time;
    }
    @Override
    public int compareTo(Route r) {
        return this.time - r.time;
    }
}

public class Main {
    static int n, m, x;
    static List<ArrayList<Route>> list = new ArrayList<>();
    static List<ArrayList<Route>> reverseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.get(start).add(new Route(end, t));
            reverseList.get(end).add(new Route(start, t));
        }

        int max = Integer.MIN_VALUE;
        int[] result = dijkstra(list);
        int[] reverseResult = dijkstra(reverseList);

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i] + reverseResult[i]);
        }
        System.out.println(max);

    }
    static int[] dijkstra(List<ArrayList<Route>> list) {
        PriorityQueue<Route> pq = new PriorityQueue<>();

        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        pq.offer(new Route(x, 0));
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            int num = cur.to;
            if (visit[num]) continue;
            visit[num] = true;
            for (Route r : list.get(num)) {
                if (!visit[r.to] && dist[r.to] > (dist[num] + r.time)) {
                    dist[r.to] = +dist[num] + r.time;
                    pq.offer(new Route(r.to, dist[r.to]));
                }
            }
        }
        return dist;
    }
}
