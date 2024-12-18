package Study;

import java.util.*;
import java.io.*;

public class BOJ1697 {
    static int n,m;
    static int[] visited = new int[100001];
    static int[] move = {-1,1,2};
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if (n==m) System.out.println(0);
        else bfs(n);
    }

    public static void bfs(int v) {
        visited[v] = 1;
        q.offer(v);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int target = q.poll();
                for (int j=0; j<3; j++) {
                    int next;
                    if (j==2) next = target * move[j];
                    else next = target + move[j];

                    if (next==m) {
                        System.out.println(visited[target]);
                        return;
                    }

                    if (next>=0 && next<100001 && visited[next]==0) {
                        q.offer(next);
                        visited[next] = visited[target] + 1;
                    }
                }
            }
        }
    }
}
