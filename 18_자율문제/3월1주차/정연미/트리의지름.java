package Algo_스터디.Mar_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class node{
    int end;
    int cost;
    public node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
        }
public class 트리의지름 {
    static List<node>[] list;
    static boolean[] visit;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new node(end,cost));
            list[end].add(new node(start,cost));
        }

        int start = N/2+1;
        for(int i=start; i<=N; i++){
            visit = new boolean[N+1];
            visit[i] = true;
            DFS(i,0);
        }
        System.out.println(result);

    }
    public static void DFS(int i, int cost){
        for(node next : list[i]){
            if(!visit[next.end]){
                visit[next.end]= true;
                DFS(next.end, next.cost+cost);
            }
        }
        result = (result < cost)? cost: result;
    }
}
