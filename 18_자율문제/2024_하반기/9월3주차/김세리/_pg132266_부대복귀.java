import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1. 그래프 생성
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
        
        // 2. BFS를 이용한 최단 거리 계산
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); // 초기값을 -1로 설정하여 방문 여부를 확인
        
        bfs(graph, distances, destination);
        
        // 3. 결과 계산 및 반환
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distances[sources[i]];
        }
        
        return result;
    }
    
    // BFS를 이용하여 각 지점에서 목표 지점까지의 최단 거리를 계산
    private void bfs(List<List<Integer>> graph, int[] distances, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0; // 목표 지점에서 자신까지의 거리는 0
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDistance = distances[current];
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 지점이라면
                    distances[neighbor] = currentDistance + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}
