package Algo_스터디.Dec_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리 조건 : 간선의 개수 = (정점의 개수 -1) *2 가 성립할 때.
// 입력받기 arraylist
// dfs 구현 : 간선의 개수와 정점의 개수 세기
// 트리 조건에 따라 출력하기

public class 트리_4803 {
    static boolean[] visit;
    static List<Integer>[] array;
    static StringBuilder sb = new StringBuilder();
    static int N, M, vertex, edge,Testcase =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
           st = new StringTokenizer(br.readLine());
           N = Integer.parseInt(st.nextToken());
           M = Integer.parseInt(st.nextToken());
           if(N==0 && M ==0) break;
           visit = new boolean[N+1];
           array = new ArrayList[N+1];
           for(int i =1; i<=N; i++) array[i] = new ArrayList<>();
           for(int i=0; i<M; i++) {
               st = new StringTokenizer(br.readLine());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               array[a].add(b);
               array[b].add(a);
           }
           // 입력 받기 완료
            Solve();
        }
        System.out.print(sb.toString());
    }

    public static void Solve(){
        Testcase ++;
        int treecnt =0;
        for(int i=1; i<=N; i++){
            if(visit[i]) continue;
            vertex =0; // 정점 개수
            edge =0; // 간선 개수
            DFS(i);
            if(edge == (vertex-1)*2) treecnt ++;
        }

        sb.append("Case "+Testcase+": ");
        if(treecnt ==0) sb.append("No trees.");
        else if(treecnt ==1) sb.append("There is one tree.");
        else sb.append("A forest of "+treecnt+" trees.");
        sb.append("\n");
    }
    public static void DFS(int i){
        vertex ++;
        edge += array[i].size();
        visit[i] = true;
        for(int a : array[i]){
            if(visit[a]) continue;
            DFS(a);
        }
    }
}

