import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, k, answer;
    static boolean[][] colored, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        colored = new boolean[n][m];
        visited = new boolean[n][m];
        answer = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            color(x, y, a, b);
        }
        //입력 완. 직사각형 표시까지 완료!
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!colored[i][j] && !visited[i][j]) {
                    int area = bfs(i, j);
                    list.add(area);
                    answer++;
                }
            }
        }
        Collections.sort(list);
        for (int i: list) {
            sb.append(i).append(" ");
        }

        System.out.println(answer);
        System.out.println(sb.toString());

    }
  //영역 색칠하기
    static void color(int r, int c, int x, int y) {
        for (int i = r; i < x; i++) {
            for (int j = c; j < y; j++) {
                colored[i][j] = true;
            }
        }
    }
  // 넓이 구하기
    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = current.x + dr[i];
                int my = current.y + dc[i];
                if (mx >= 0 && my >= 0 && mx < n && my < m && !colored[mx][my] && !visited[mx][my]) {
                    q.add(new Node(mx, my));
                    visited[mx][my] = true;
                }
            }
            count++;

        }
        return count;
    }
}
