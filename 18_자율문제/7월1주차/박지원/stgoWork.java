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

        //출발점에서 갈수있는 모든 정점을 저장한다
        Set<Integer> s1 = new HashSet<>();
        //도착점(T)에서 출발하여 역방향 간선을 통해 도달할 수 있는 모든 정점들입니다
        Set<Integer> s2 = new HashSet<>();

        dfs(s, t, graph, s1, new boolean[n+1]);
        dfs(t, -1, reverseGraph, s2, new boolean[n+1]);

        s1.retainAll(s2); //교집합 S에서 출발하여 도달할 수 있고, 동시에 T에서 출발하여 역방향으로 도달할 수 있는 정점들을 의미/ S에서 출발하여 T에 도달하는 경로에 포함될 수 있는 모든 정점

        //도착점(T)에서 출발하여 도달할 수 있는 모든 정점들
        Set<Integer> s3 = new HashSet<>();
        //출발점(S)에서 출발하여 역방향 간선을 통해 도달할 수 있는 모든 정점들
        Set<Integer> s4 = new HashSet<>();

        dfs(t, s, graph, s3, new boolean[n+1]);
        dfs(s, -1, reverseGraph, s4, new boolean[n+1]);

        s3.retainAll(s4); //T에서 출발하여 S에 도달하는 경로에 포함될 수 있는 모든 정점을 식별

        //S에서 T로 가는 경로와 T에서 S로 가는 경로에 모두 포함되는 정점들을 식별합니다. 이렇게 함으로써, S에서 T로 가는 경로와 T에서 S로 가는 경로에서 공통으로 도달 가능한 모든 정점을 구하게 됩니다.
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

//이 과정이 필요한 이유는 방향 그래프에서 특정 두 정점 사이의 경로에 포함된 정점들을 정확히 식별하기 위함입니다. 두 정점 사이의 경로를 양방향으로 탐색하여 두 경로에 공통으로 포함되는 정점들을 구해야만 S와 T 사이의 모든 경로에 포함된 정점을 올바르게 찾을 수 있습니다.
