package Algo_스터디.Jan_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시간초과 

class node implements Comparable<node>{
    int ed;
    int cost;
    public node(int ed, int cost){
        this.ed= ed;
        this.cost=cost;
    }

    @Override
    public int compareTo(node n){
        return this.cost - n.cost;
    }
}

public class 최소비용구하기2 {
    static int[] dist;
    static boolean[] visit;
    static int spoint, epoint;
    static ArrayList<node>[] adj;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        spoint = Integer.parseInt(st.nextToken());
        epoint = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        visit = new boolean[n+1];
        road = new int[n+1];

        distra();
        System.out.println(dist[epoint]);

        ArrayList<Integer> roads = new ArrayList<>();
        int curr = epoint;
        while(curr !=0){
            roads.add(curr);
            curr = road[curr];
        }
        System.out.println(roads.size());
        for(int i=roads.size()-1; i>=0; i--) System.out.print(roads.get(i)+" ");
    }
    public static void distra(){
        PriorityQueue<node> q = new PriorityQueue<>();

        q.add(new node(spoint,0));
        dist[spoint] =0;

        while(!q.isEmpty()){
            node now = q.poll();
            if(!visit[now.ed]) visit[now.ed] = true;

            for(node next : adj[now.ed]){
                if(!visit[next.ed] && dist[next.ed]>now.cost+next.cost){
                    dist[next.ed] = now.cost+next.cost;
                    road[next.ed] = now.ed;
                    q.add(new node(next.ed,dist[next.ed]));
                }
            }
        }
    }

}
