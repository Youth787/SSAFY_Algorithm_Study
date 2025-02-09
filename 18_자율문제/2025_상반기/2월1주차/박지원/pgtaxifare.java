//프로그래머스 합승 택시 요금 자바
//다익스트라 연습으로 딱좋은문제

import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Node>> list;
    
    private static class Node implements Comparable<Node> {
        int num, cost;
        public Node (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    
    // 다익스트라 알고리즘을 이용해 start에서 모든 노드까지의 최단 거리 계산
    private static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > dist[now.num]) continue;
            
            for (Node next : list.get(now.num)) {
                int nextCost = now.cost + next.cost;
                if (nextCost < dist[next.num]) {
                    dist[next.num] = nextCost;
                    pq.add(new Node(next.num, nextCost));
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        
        for (int[] fare : fares) {
            int to = fare[0];
            int from = fare[1];
            int fee = fare[2];
            list.get(to).add(new Node(from, fee));
            list.get(from).add(new Node(to, fee));
        }
        
        // s, a, b에서 출발하는 다익스트라 실행
        int[] distFromS = dijkstra(s, n);
        int[] distFromA = dijkstra(a, n);
        int[] distFromB = dijkstra(b, n);

        // 최소 비용 계산
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distFromS[i] == Integer.MAX_VALUE || distFromA[i] == Integer.MAX_VALUE || distFromB[i] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
        }

        return answer;
    }
}
