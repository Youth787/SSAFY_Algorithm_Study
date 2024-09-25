import java.util.*;

class Solution {
    
    boolean[] visited;
    boolean[][] relative;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];
        relative = new boolean[n + 1][n + 1];
        
        answer = bfs(edge);
        return answer;
    }
    
    public int bfs(int[][] edge) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            relative[x][y] = true;
            relative[y][x] = true;
        }
        
        int size = 0;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int j = 1; j < visited.length; j++) {
                    if (!visited[j] && relative[current][j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        
        return size;
    }
}
