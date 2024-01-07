package Algo_스터디.Jan_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://st-lab.tistory.com/243 : comparable, comparator 에 대한 비교
// comparable : 자기 자신과 매개변수 객체를 비교, compareTo 메소드를 반드시 구현해야한다.
// comparator : 두 매개변수 객체를 비교, compare(type o1, type o2) 를 사용

class node implements Comparable<node> {
    int index;
    int weight;
    public node(int index, int weight){
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(node o){
        return this.weight - o.weight; // 디폴트가 오름차순이므로 양수일경우 swapping
    }
}

public class 최단경로_1753 {
        static List<node>[] adj;
        static int[] dist;
        static boolean[] visit;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(br.readLine());

            adj = new ArrayList[V+1];
            dist = new int[V+1];
            visit = new boolean[V+1];

            for(int i=1; i<=V; i++) {
                adj[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());

                adj[start].add(new node(end, W));
            }

            dijkstra(K);

            for(int i =1; i<=V; i++) System.out.println(dist[i]==Integer.MAX_VALUE? "INF":dist[i]);

        }
        public static void dijkstra(int start){
            // PriorityQueue<node> q = new PriorityQueue<>((o1, o2)-> o1.weight - o2.weight);// 오름차순
            // compareTo 메서드 클래스 내에서 구현하지 않고 위와 같이 구현도 가능.
            PriorityQueue<node> q = new PriorityQueue<>();
            q.add(new node(start, 0));
            dist[start] = 0;

            while(!q.isEmpty()){
                node curr = q.poll();

                if(!visit[curr.index]) visit[curr.index]= true;

                for(node next : adj[curr.index]){
                    if(!visit[next.index] && dist[next.index]> curr.weight + next.weight){
                        dist[next.index] = curr.weight + next.weight;
                        q.add(new node(next.index, dist[next.index]));
                    }
                }
                //for(node i : q) System.out.print(i.weight+" ");
                //System.out.println();
            }
        }
    }
