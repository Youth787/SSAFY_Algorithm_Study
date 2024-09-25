package p1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시작점에서 다른 모든 정점으로의 최단경로 
 * 입력 : 정점 개수  v, 간선 수  e/ u에서 v로 가는 간선의 가중치 w. 여러 간선 존재할 수도
 * 출력 : i번 정점까지 가는 최단 경로, 경로 없으면 INF, 시작점 자신은 0
 * */


public class Main {
	
    static ArrayList[] adjList;
    static int[] dist; //최단 경로 저장 배열
    static int V; //정점 개수
    static int E; //간선 수
    static int K; //시작 정점 위치
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) -1;//시작점 자신은 거리 0
        
        adjList = new ArrayList[V];
        dist = new int[V];
        
        for (int i = 0; i < V; i++) {
        	adjList[i] = new ArrayList<Node>(); //각각 어디서 어디까지
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }
        
        //다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[K] = 0; //시작점 본인은 0
        pq.add(new Node(K, 0));
        
        while (!pq.isEmpty()) {
        	Node curr = pq.poll();
        	int len = adjList[curr.v].size();
        	for (int i = 0; i < len; i++) {
        		Node next = (Node)adjList[curr.v].get(i);
        		if (dist[next.v] > curr.w + next.w) {
        			dist[next.v] = curr.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
        		}
        	}
        }
       
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
        
	} //main
	static class Node implements Comparable <Node>{
		int v;
		int w;
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
			
		}
		@Override
		public int compareTo(Node o) { //본인과 o를 compareTo 비교한 결과
			return this.w - o.w;
		}
	}
} //class
