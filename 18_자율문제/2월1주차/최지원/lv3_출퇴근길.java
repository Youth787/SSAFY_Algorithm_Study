import java.io.*;
import java.util.*;
/*
 * 단방향 그래프. n개의 동네(정점), m개의 일방통행도로(간선), 집은 S, 회사는 T
 * 출근길 경로와 퇴근길 경로에 모두 포함될 수 있는 정점의 개수
목적지는 한번만 찍어야 하지만 중간에 출발점은 여러번 찍어도 됨
 https://www.youtube.com/watch?v=PAihI2CGr-M 해설 강의있읍!!
 */

public class Main {
    static int n, m;
    static int s, t;
    static List<List<Integer>> graph; //출근길
    static List<List<Integer>> reverseGraph; //퇴근길

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  // 동네(정점)의 개수
        m = Integer.parseInt(st.nextToken());  // 일방통행 도로(간선)의 개수
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());       // 그래프 초기화
            reverseGraph.add(new ArrayList<>());  // 역방향 그래프 초기화
        }

        // 일방통행 도로 정보 입력 및 그래프 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);               // 그래프에 정방향 간선 추가
            reverseGraph.get(v).add(u);        // 역방향 그래프에 역방향 간선 추가
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());  // 출근 동네
        t = Integer.parseInt(st.nextToken());  // 퇴근 동네

        Set<Integer> s1 = new HashSet<>();  // s에서 도달할 수 있는 중간 정점들을 저장할 집합
        Set<Integer> s2 = new HashSet<>();  // t에서 역방향 간선을 통해 도달할 수 있는 정점을 저장할 집합
        
        // s에서 출발하여 t까지 도달 가능한 정점 찾기, 인자로 각각 방문배열을 들고 다닌다
        dfs(s, t, graph, s1, new boolean[n + 1]);
        
        // 역방향 간선을 통해 t에서 s로 도달 가능한 정점 찾기
        dfs(t, -1, reverseGraph, s2, new boolean[n + 1]);

        // 두 집합의 교집합을 구함
        s1.retainAll(s2);

        Set<Integer> s3 = new HashSet<>();  // t에서 도달할 수 있는 정점들을 저장할 집합
        Set<Integer> s4 = new HashSet<>();  // s에서 역방향 간선을 통해 도달할 수 있는 정점을 저장할 집합
        
        // t에서 출발하여 s까지 도달 가능한 정점 찾기
        dfs(t, s, graph, s3, new boolean[n + 1]); //인자로는
        
        // 역방향 간선을 통해 s에서 도달 가능한 정점 찾기
        dfs(s, -1, reverseGraph, s4, new boolean[n + 1]);

 
        s3.retainAll(s4);
        s1.retainAll(s3); // 두 교집합의 교집합을 구함
        
        //retainAll = 지정된 컬렉션에 포함되지 않은 모든 배열 목록 요소를 제거하거나 
        //메서드에 매개 변수로 전달된 컬렉션 목록의 모든 요소와 일치하는 현재 컬렉션 인스턴스의 모든 일치 요소를 유지하는 데 사용되는 메서드
        // +) ArrayList addAll (합집합)
        // ++) removeAll (차집합)
        // +++) retainAll (교집합)

        int answer = s1.size();  // 출근 및 퇴근길 경로에 동시에 포함될 수 있는 정점의 개수

        // 출근 동네와 퇴근 동네가 해당 정점에 포함되어 있다면 각각 하나씩 제거
        if (s1.contains(s)) answer--;
        if (s1.contains(t)) answer--;

        System.out.println(answer);  // 정답 출력
    }

    public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set, boolean[] visited) {
        //현재 정점 (node)에서 시작. 
        if (stop != -1 && node == stop) {
            return;  // 정지 조건: stop이 -1이 아니고 현재 정점이 stop 정점과 같으면 함수 종료
        } // = 목표 위치에 도달했다는 것임

        for (int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i); //현재 정점(node)와 연결된 다른 정점들을 탐색

            if (visited[next]) continue;  // 이미 방문한 정점은 건너뛰기

            visited[node] = true;  // 현재 정점을 방문한 것으로 표시
            set.add(next);        // 집합(set)에 정점 추가
            dfs(next, stop, graph, set, visited);  // 다음 정점에서 dfs를 재귀 호출
        }

        return;  // 모든 정점을 방문하고 탐색 끝났으니까 함수 종료 = 그럼 set에 방문한 정점이 저장되어있음
    }
}
