import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class bj2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 갯수
        int k = Integer.parseInt(br.readLine()); // 연결된 쌍 갯수
        int[][] computer = new int[n + 1][n + 1]; // >> int보단 boolean으로 만들기!!!!
        computer[1][1] = 1;
        int cnt = 0;
        StringTokenizer st;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            computer[from][to] = 1;
            computer[to][from] = 1;
        }
        //입력 끝
        Queue<Integer> q = new LinkedList<>(); // 연결되어있는데 방문하지 않은 애들 넣어줄것임.
        boolean[] visited = new boolean[n + 1]; // 방문쳌
        q.add(1); // 1번부터 바이러스 전염되니까 1 넣어주고
        visited[1] = true; // 방문처리
        while (!q.isEmpty()) { // 큐가 빌때까지 돌려!!!
            int now = q.poll(); // 현재 내가 있는 노드를 now로 두고
            for (int i = 1; i <= n; i++) { // 1~n까지 돌면서 
                int next = computer[now][i];
                if (next == 1 && !visited[i]) { // 연결되어있는데 방문하지 않은애들이 있다면
                    q.add(i); // 큐에 넣어주고
                    visited[i] = true; // 방문했다~
                    cnt++; // 연결된 갯수니까 체크해주고
                }
            }
        }


        System.out.println(cnt);
    }
}
