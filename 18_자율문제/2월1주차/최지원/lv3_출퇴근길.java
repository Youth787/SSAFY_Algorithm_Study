import java.io.*;
import java.util.*;
/*
 * 단방향 그래프. n개의 동네(정점), m개의 일방통행도로(간선), 집은 S, 회사는 T
 * 출근길 경로와 퇴근길 경로에 모두 포함될 수 있는 정점의 개수
 */
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
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        //s에서 도달할 수 있는 중간 정점들 
        dfs(s, t, graph, s1, new boolean[n+1]);
        //역방향 간선에 대해서 t에서 도달할 수 있는 정점 -> s->t에서 도달가능한 정점
        dfs(t, -1, reverseGraph, s2, new boolean[n+1]);

        s1.retainAll(s2); //교집합

        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        //t에서 도달할 수 있는 정점들
        dfs(t, s, graph, s3, new boolean[n+1]);
        //역방향 간선에 대해서 s에서 도달할 수 있는 정점들 
        dfs(s, -1, reverseGraph, s4, new boolean[n+1]);

        s3.retainAll(s4);

        s1.retainAll(s3);
        
        int answer = s1.size();

        if(s1.contains(s)) answer--;
        if(s1.contains(t)) answer--;

        System.out.println(answer);
    }

    public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set, boolean[] visited){
        if(stop!=-1 && node==stop){
            return;
        }

        for(int i=0; i<graph.get(node).size(); i++){
            int next = graph.get(node).get(i);

            if(visited[next]) continue;

            visited[node] = true;
            set.add(next);
            dfs(next, stop, graph, set, visited);
        }

        return;

    }
}
