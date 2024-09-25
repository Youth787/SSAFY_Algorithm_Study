package _20240911;

import java.util.*;

public class _1325_효율적인해킹 {
	static int N, M;
    static ArrayList<Integer>[] adj; // 인접 리스트로 그래프 표현
    static boolean[] visited;
    static int[] result; // 각 컴퓨터가 해킹할 수 있는 컴퓨터 수 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        adj = new ArrayList[N+1];
        result = new int[N+1];
        
        // 인접 리스트 초기화
        for (int i=1;i<=N;i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 신뢰 관계 입력 받기
        for (int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[b].add(a); // b가 a를 신뢰한다는 것은 b가 a를 해킹할 수 있음을 의미
        }
        
        // 모든 컴퓨터에 대해 DFS/BFS 탐색
        for (int i=1;i<=N;i++) {
            visited = new boolean[N+1]; // 탐색마다 방문 초기화
            result[i] = bfs(i); // i번 컴퓨터에서 BFS 탐색
        }
        
        // 최대 해킹 가능한 컴퓨터 수 찾기
        int maxHacks = Arrays.stream(result).max().getAsInt();
        
        // 최대 해킹 가능한 컴퓨터들 출력
        for (int i=1;i<=N;i++) {
            if (result[i] == maxHacks) {
                System.out.print(i + " ");
            }
        }
    }
    
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count; // 해킹할 수 있는 컴퓨터 수
    }
}
