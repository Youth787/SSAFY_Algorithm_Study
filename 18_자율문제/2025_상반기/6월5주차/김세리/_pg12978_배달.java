import java.util.*;
import java.io.*;

class Solution {
    static class Node implements Comparable<Node>{
        int end;
        int time;
        Node(int end, int time){
            this.end=end;
            this.time=time;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time,o.time);
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Node>>graph = new ArrayList<>();
        
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            graph.get(r[0]).add(new Node(r[1],r[2]));
            graph.get(r[1]).add(new Node(r[0],r[2]));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1]=0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currV = curr.end;
            int currT = curr.time;
            if(dist[currV]<currT) continue;
            for(Node next:graph.get(currV)){
                int nextV = next.end;
                int nextT = next.time;
                if(nextT+currT<dist[nextV]){
                    dist[nextV] = nextT+currT;
                    pq.add(new Node(nextV,nextT+currT));
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }

        return answer;
    }
}
