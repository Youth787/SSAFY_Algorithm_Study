//백준 뱀과 사다리 게임 자바
//BFS

import java.io.*;
import java.util.*;

public class Main{
    private static int[] board;
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }
        System.out.println(BFS(1));

    }
    private static int BFS(int start) {
        int[] visited = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 0;
        while (true) {
            int now = q.poll();
            for (int i = 1; i < 7; i++) {
                int goNode = now + i;
                if (now > 100) continue;
                if (visited[board[goNode]] == 0) {
                    q.offer(board[goNode]);
                    visited[board[goNode]] = visited[now] + 1;
                }
                if (board[goNode] == 100) return visited[100];
            }
        }
    }


}

