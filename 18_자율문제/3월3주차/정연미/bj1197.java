package Algo_스터디.Mar_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int to;
    int cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o){
        return this.cost-o.cost;
    }
}

public class 최소스패닝트리 {
    static int total=0;
    static List<Node>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        // BFS로 풀 경우.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=1; i <=V; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));
        }

        BFS(1);
        System.out.println(total);

    }
    public static void BFS(int to){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(to,0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int go = current.to;
            int cost = current.cost;

            if(visit[go]) continue;
            visit[go] = true;
            total += cost;

            for(Node next : list[go]){
                if(!visit[next.to]){
                    pq.add(next);
                }
            }
        }
    }
}
