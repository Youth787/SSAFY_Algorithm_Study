package Study;

import java.util.*;
import java.io.*;

public class BOJ12851 {
    static int n,m;
    static int[] visited = new int[100001];
    static int[] move = {-1,1,2};
    static Queue<Integer> q = new LinkedList<>();
    static int min = 987654321;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if (n>=m) {
            System.out.println((n-m)+"\n1");
        }
        bfs(n);
        System.out.println(min+"\n"+count);
    }

    public static void bfs(int v) {
        visited[v] = 1;
        q.offer(v);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (min<visited[now]) return;

                for (int j=0; j<3; j++) {
                    int next;
                    if (j==2) next = now * move[j];
                    else next = now + move[j];

                    if (next<0 || next>100000) continue;

                    if (next==m) {
                        min = visited[now];
                        count++;
                    }

                    if (visited[next]==0 || visited[next]==visited[now]+1) {
                        q.offer(next);
                        visited[next] = visited[now] + 1;
                    }
                }
            }
        }
    }
}
