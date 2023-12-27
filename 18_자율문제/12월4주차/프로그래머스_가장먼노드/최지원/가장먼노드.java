import java.util.*;

class Solution {
    static List <List<Integer>> adjList = new ArrayList<>();//인접 리스트로 간선 정보 저장
    static boolean [] visited;//방문처리
    static int [] distance; //최단 거리 저장

    public int solution(int n, int[][] edges) {
        visited = new boolean [n];
        distance = new int [n];
		
        Arrays.fill(distance, Integer.MAX_VALUE);//최소값이니까 최대로 초기화

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {     
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);//양방향
        }

        BFS(0);

        Arrays.sort(distance);
        int cnt = 1;
        for(int i = distance.length - 1; i > 0; i--, cnt++) {
            if(distance[i] != distance[i - 1]) {
                break;
            }
        }
        return cnt;
    }//solution

    static void BFS(int v) {
        Queue <Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        distance[v] = 0;

        while(!queue.isEmpty()) {
            Integer w = queue.poll();
            for (Integer e : adjList.get(w)) {
                if(!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                    distance[e] = Math.min(distance[e], distance[w] + 1);
                }
            }
        }//queue
    }//BFS
}//class
