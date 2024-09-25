import java.io.*;
import java.util.*;

//https://dhbang.tistory.com/12
public class Main1389_6stage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 친구의 수(V)
	    M = Integer.parseInt(st.nextToken()); // 관계의 수(E)
	    dist = new int[N + 1]; // 카운트 체크
	    graph = new ArrayList[N + 1];
	    for (int i = 1; i <= N; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    for (int i = 1; i <= M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
	        graph[x].add(y); // x번 유저와 y번 유저는 연결되어 있다!
	        graph[y].add(x); // 무방향 그래프로 반대 입장도 연결하자!
	    }

	    solution();
	}

	// N만큼 각각 BFS를 돌려 최댓값을 갱신한다.
	static void solution() {
	    int minCnt = Integer.MAX_VALUE, minIdx = 0; // 최소 카운트와 해당 정점 번호
	    for (int i = 1; i <= N; i++) {
	        int cnt = BFS(i);
	        if (minCnt > cnt) { // 최소 카운트 및 정점 번호 갱신
	            minCnt = cnt;
	            minIdx = i;
	        }
	    }
	    System.out.println(minIdx);
	}

	static int BFS(int start) {
	    Arrays.fill(dist, -1); // 방문여부 및 카운트 초기화
	    int cnt = 0;
	    Queue<Integer> Q = new LinkedList<>();
	    Q.add(start);
	    dist[start] = 0;

	    while(!Q.isEmpty()) {
	        int x = Q.poll();
	        for (int y : graph[x]) {
	            if (dist[y] != -1) continue;
	            dist[y] = dist[x] + 1;
	            cnt+= dist[y]; // 이동 횟수를 누적해주자!
	            Q.add(y);
	        }
	    }
	    return cnt;
	}
}
