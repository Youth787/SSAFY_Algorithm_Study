import java.util.*;
import java.io.*;

class Solution {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        tree = new ArrayList<>();
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[] edge : lighthouse){
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int answer = 0;
        dfs(1);
        // 결국 처음 시작점인 1번 노드 등대가 켜져있을때 경우와 꺼져있을 때 경우 중
        // 값이 작은 것을 반환하면 된다
        return Math.min(dp[1][0], dp[1][1]);
    }
    void dfs(int node){
        visited[node]=true;
        // 껐을때
        dp[node][0] = 0;
        // 켰을때
        dp[node][1] = 1;
        for(int next:tree.get(node)){
            // 그 다음노드 방문 안했던 곳이라면
            if(!visited[next]){
                dfs(next);
                // 다음 노드가 켜져있다면 지금 노드는 꺼도된다
                dp[node][0] += dp[next][1];
                // 다음 노드가 꺼져있다면 지금 노드는 켜야한다
                dp[node][1] += Math.min(dp[next][0],dp[next][1]);
            }
            
        }
    }
    
}
