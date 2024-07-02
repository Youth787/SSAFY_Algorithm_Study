//소프티어 출퇴근길 lv3
//dfs의 세계는 너무 어렵다..

import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static int s, t;
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
      //출근길과 퇴근길을 위해 graph, reverseGraph 두가지를 받아준다.
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
          //반대로받아주기
            reverseGraph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        //출발점 -> 중간지점 저장
        Set<Integer> s1 = new HashSet<>();
        //도착점 -> 중간지점 저장소
        Set<Integer> s2 = new HashSet<>();
        //s에서 도달할 수 있는 중간 정점들 
        dfs(s, t, graph, s1, new boolean[n+1]);
        //역방향 간선에 대해서 t에서 도달할 수 있는 정점 -> s->t에서 도달가능한 정점
        dfs(t, -1, reverseGraph, s2, new boolean[n+1]);

        s1.retainAll(s2); //교집합

        //도착점 -> 출발점 저장소
        Set<Integer> s3 = new HashSet<>();
        //출점 -> 도착점 저장
        Set<Integer> s4 = new HashSet<>();
        //t에서 도달할 수 있는 정점들
        dfs(t, s, graph, s3, new boolean[n+1]);
        //역방향 간선에 대해서 s에서 도달할 수 있는 정점들 
        dfs(s, -1, reverseGraph, s4, new boolean[n+1]);

        s3.retainAll(s4);

        //최종적으로 s1, s3의 교집
        s1.retainAll(s3);
        
        int answer = s1.size();

        //출발점, 도착점이 포함되어있다면 사이즈 하나 줄이기
        if(s1.contains(s)) answer--;
        if(s1.contains(t)) answer--;

        System.out.println(answer);
    }

    //node에서 시작하여 stop이 되면 멈추는 재귀함수
    public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set, boolean[] visited){
        if(stop!=-1 && node==stop){
            return;
        }

        for(int i=0; i<graph.get(node).size(); i++){
            int next = graph.get(node).get(i);

            if(visited[next]) continue;

            visited[node] = true;
            //방문한 정점 추가
            set.add(next);
            dfs(next, stop, graph, set, visited);
        }

        return;

    }
}
