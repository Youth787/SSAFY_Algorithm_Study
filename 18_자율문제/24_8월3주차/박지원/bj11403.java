//백준 경로찾기 자바
//플로이드와샬 알고리즘(O(n^3)이 가능해서 가능, 아니었으면 dfs로 visit체크해서 풀어야할듯)

import java.io.*;
import java.util.*;

public class Main{
    private static int n;
    private static int[][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //플로이드 와샬 알고리즘(경출도)
        for (int k = 0 ; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][k] == 1 && adj[k][j] == 1) { // 출발점과 경유지가 연결되어있고, 경유지와 도착점이 연결되어있을때, 출발지와 도착지가 연결되게끔 만든다.
                        adj[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

