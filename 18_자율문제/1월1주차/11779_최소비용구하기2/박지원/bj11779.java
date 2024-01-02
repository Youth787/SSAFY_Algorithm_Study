import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
    int num;
    int cost;
    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
public class Main {

    static int n, m, start, end;
    static int[][] map;
    static int[] dist, route;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(route, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], price);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        //입력 끝

        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[current.num][i] == Integer.MAX_VALUE) continue;
                int nextCost = current.cost + map[current.num][i];
                if (nextCost >= dist[i]) continue;
                dist[i] = nextCost;
                q.add(new Node(i, nextCost));
                route[i] = current.num;
            }
        }
        ArrayList<Integer> routines = new ArrayList<>();
        routines.add(end);
        int next = end;
        while (next != start) {
            next = route[next];
            routines.add(next);
        }
        Collections.reverse(routines);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(routines.size()).append("\n");
        for (int i: routines)
            sb.append(i).append(" ");

        System.out.println(sb);

    }
}
