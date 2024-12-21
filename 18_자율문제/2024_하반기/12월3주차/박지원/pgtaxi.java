//프로그래머스 합승 택시 요금 자바
//실패코드(시간초과) 다익스트라
//플로이드와샬 써야할듯

import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Node>> list = new ArrayList<>();
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
    private static int dijkstra (int start, int end, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > dist[now.num]) continue;
            ArrayList<Node> connect = list.get(now.num);
            for (Node next: connect) {
                int nextCost = next.cost + now.cost;
                if (nextCost < dist[next.num]) {
                    dist[next.num] = nextCost;
                    pq.add(new Node(next.num, nextCost));
                }
            }
        }
        
        return dist[end];
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] arr: fares) {
            int to = arr[0];
            int from = arr[1];
            int fee = arr[2];
            list.get(to).add(new Node(from, fee));
            list.get(from).add(new Node(to, fee));
        }
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dijkstra(s, i, n) + dijkstra(i, a, n) + dijkstra(i, b, n));
        }
       
        return answer;
    }

}
