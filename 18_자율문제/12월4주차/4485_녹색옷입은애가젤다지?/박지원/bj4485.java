import java.util.*;
import java.io.*;
//다익스트라.. 노드 클래스 정의할 때 compareTo 함수도 같이 해주기!!
public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { // 이렇게 정의해서 노드끼리의 코스트를 비교해보자
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            map = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
          //입력 완.
            int cost = bfs();

            sb.append("Problem " + testCase + ": " + cost + "\n");
            testCase++;
        }
        System.out.println(sb.toString());

    }
    static int bfs() {
      //우선순위 큐를 하나 설정하고 이차원 배열 만들어서 최대인트값을 다 넣어준다.
        Queue<Node> q = new PriorityQueue<>();
        int[][] move = new int[n][n];
      
        for (int i = 0; i < n; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }
      // 0, 0 부터 시작!!
        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];
      
        while(!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x, py = pos.y;
            int cost = pos.cost;

            if (px == n - 1 && py == n - 1) { // 도착지점이라면 ? cost 반환!
                return cost;
            }
            for (int i = 0; i < 4; i++) { // bfs를 돌린다!!
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;
              //이부분이 중요!! 만약 cost에 현재 위치 코스트를 더한게 만약 move의 값보다 작다? 그러면move값을 갱신해준다! 그 후 큐에 추가하기!
                if (cost + map[ny][nx] < move[ny][nx]) {
                    move[ny][nx] = cost + map[ny][nx];
                    q.add(new Node(nx, ny, cost + map[ny][nx]));
                }
            }
        }
        return -1;
    }
}
//https://loosie.tistory.com/414
