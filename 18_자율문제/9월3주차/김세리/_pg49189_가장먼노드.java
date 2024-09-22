import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접 리스트로 그래프를 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프에 간선 추가
        for (int[] e : edge) {
            graph.get(e[0]-1).add(e[1]-1);
            graph.get(e[1]-1).add(e[0]-1);
        }
        
        // 거리 배열 초기화
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[0] = 0; // 시작 노드는 0으로 설정
        
        // BFS 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        // BFS를 이용한 최단 거리 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 노드만 탐색
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // 최대 거리 계산
        int maxDistance = 0;
        for (int distance : distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        
        // 최대 거리를 가지는 노드의 개수 계산
        int count = 0;
        for (int distance : distances) {
            if (distance == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}
