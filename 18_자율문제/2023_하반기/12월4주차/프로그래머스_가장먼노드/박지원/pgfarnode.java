import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i: edge) {
            int v = i[0];
            int w = i[1];
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        
        boolean[] visited = new boolean[n + 1];
        return bfs(graph, n, visited);
    }
    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        
        q.add(new int[] {1, 0});
        visited[1] = true;
        int maxDepth = 0;
        
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int v = arr[0];
            int depth = arr[1];
            
            if (maxDepth == depth) answer++;
            else if (maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for (int i = 0; i < graph.get(v).size(); i++) {
                int w = graph.get(v).get(i);
                if (!visited[w]) {
                    q.add(new int[] {w, depth + 1});
                    visited[w] = true;
                }
            }
        }
        return answer;
    }
}
