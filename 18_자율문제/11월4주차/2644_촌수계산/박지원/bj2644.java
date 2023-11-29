import java.io.*;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;
//visited말고 dist로 target1부터의 거리를 계산해두자!
//2차&bfs로 풀기
public class Main {

    static int n, target1, target2, answer;
    static boolean[][] map;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // ㅅㅏ람수
        answer = -1;
        String[] target = br.readLine().split(" ");
        target1 = Integer.parseInt(target[0]);
        target2 = Integer.parseInt(target[1]);
        map = new boolean[n + 1][n + 1]; // 0은안씀
        dist = new int[n + 1];

        int m = Integer.parseInt(br.readLine()); // 부모자식들 간 관계의 갯수
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = true;
        }
        bfs(target1, target2);
        if (dist[target2] == 0) {
            System.out.println(answer);
        } else {
            System.out.println(dist[target2]);
        }
    }
    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                if (map[current][i] && dist[i] == 0) {
                    dist[i] = dist[current] + 1;
                    q.add(i);
                }
            }
        }
    }
}
