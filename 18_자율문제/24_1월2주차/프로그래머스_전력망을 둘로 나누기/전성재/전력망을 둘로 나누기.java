import java.util.*;

class Solution {
    static int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;
            
            answer = Math.min(answer, bfs(n, from));
             
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        return answer;
    }

    static int bfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int count = 1;
        
        Queue<Integer> q = new LinkedList<Integer>();
        visited[x] = true;
        q.offer(x);
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            
            for (int i = 1; i <= n; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return Math.abs(count - (n - count));
    }
}
