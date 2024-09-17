//프로그래머스 부대복귀 자바
//다익스트라

import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static int[] dist;
    private static int max = 987654321;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr: roads) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        dist = new int[n + 1];
        Arrays.fill(dist, max);
        dijkstra(destination);
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (dist[sources[i]] < max) ? dist[sources[i]] : -1;
        }
        return answer;
    }
    private static void dijkstra(int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(end);
        dist[end] = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int temp = list.get(now).get(i);
                if (dist[temp] > dist[now] + 1) {
                    dist[temp] = dist[now] + 1;
                    q.add(temp);
                }
            }
        }
    }
}
