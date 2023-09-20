package study;

//https://coder-in-war.tistory.com/m/entry/BOJ-JAVA21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8

// 플로이드 와샬 알고리즘 
// 다익스트라 알고리즘 
// bfs, dfs 

import java.util.*;
import java.io.*;
public class 호석이두마리치킨  {

    public static int N, M, adj[][], dist[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];
        dist = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = adj[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;

                if(adj[i][j]!=0) dist[i][j] = adj[i][j];
                else dist[i][j] = 1000000;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                int tmp = solve(i, j);
                if(sum > tmp) {
                    ans1 = i; ans2 = j;
                    sum = tmp;
                }
            }
        }

        System.out.printf("%d %d %d", ans1, ans2, sum*2);
    }

    public static int solve(int i, int j) {
        int distance = 0;
        for (int k = 1; k <= N; k++) {
            distance += Math.min(dist[i][k], dist[j][k]);
        }
        return distance;
    }
}