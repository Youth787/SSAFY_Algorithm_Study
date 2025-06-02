import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        
        bfs(graph, distances, destination);
        
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distances[sources[i]];
        }
        
        return result;
    }
    
    private void bfs(List<List<Integer>> graph, int[] distances, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDistance = distances[current];
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = currentDistance + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}
