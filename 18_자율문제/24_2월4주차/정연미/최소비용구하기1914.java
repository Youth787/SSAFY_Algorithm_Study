package Algo_스터디.Fev_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node{
    int end ;
    int cost ;
    public node(int end, int cost ){
        this.end = end;
        this.cost = cost;
    }
}

public class 최소비용구하기1916 {
    static int N, M;
    static ArrayList<ArrayList<node>> list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접 리스트로 그래프 구현하기
        list = new ArrayList<>();
        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list.get(start).add(new node(end,cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 계산하기
        dijkstra(start);
        // 결과 출력하기
        System.out.println(dist[end]);
    }
    public static void dijkstra(int idx){
        PriorityQueue<node> q = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        q.add(new node(idx,0));
        dist[idx]=0;

        while(!q.isEmpty()){
            node current = q.poll();

            if(current.cost>dist[current.end]) continue; // 시간초과 해결

            for(node next : list.get(current.end)){
                if(dist[next.end]>current.cost+next.cost) {
                    dist[next.end] = current.cost+next.cost;
                    q.add(new node(next.end, dist[next.end]));
                }
            }
        }
    }
}

// 간선의 추가/삭제가 빈번하고 동적인 상황이라면 ArrayList<ArrayList<node>>가 적합
// 노드에 대한 빠른 접근이 필요하거나 간선의 추가/삭제가 많지 않은 경우에는 ArrayList<node>[]가 유용