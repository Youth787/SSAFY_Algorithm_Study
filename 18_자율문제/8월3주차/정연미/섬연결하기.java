import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] costs) {
       // 그래프를 인접 리스트로 구성
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] cost : costs) {
            graph[cost[0]].add(new int[]{cost[1], cost[2]});
            graph[cost[1]].add(new int[]{cost[0], cost[2]});
        }

        // 최소 신장 트리에 포함된 정점을 추적
        boolean[] inMST = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{0, 0});  // 시작 정점: (정점 번호, 간선 가중치)

        int totalCost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            // 이미 방문한 정점은 무시
            if (inMST[node]) continue;

            // 현재 정점을 MST에 추가
            inMST[node] = true;
            totalCost += cost;
            edgesUsed++;

            // 인접한 정점들에 대해 간선 추가
            for (int[] neighbor : graph[node]) {
                if (!inMST[neighbor[0]]) {
                    pq.add(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }

        return totalCost;
    }
}
