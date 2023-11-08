import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260_DFS와BFS {

	static int n, m, v;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //정점 수
		m = Integer.parseInt(st.nextToken()); //간선 수
		v = Integer.parseInt(st.nextToken()); //시작 정점
		
		graph = new int[n+1][n+1]; //간선 표시할 그래프 배열 
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = 1; //간선 있으면 1 
			graph[end][start] = 1;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
		System.out.println();
		
	}
	
	static void dfs(int v) { //정점 v를 인자로 받음 
		visited[v] = true; //방문체크 
		System.out.print(v+" "); //출력 
		
		if (v>n) return; //마지막 정점까지 확인했으면 리턴 
		
		for (int i=1; i<=n; i++) {
			if (graph[v][i]==1 && visited[i]==false) dfs(i); 
			//간선 있고 아직 방문 안 했으면 재귀함수 호출로 방문 
		}
	}
	
	static void bfs(int v) { //시작 정점 v 
		Queue<Integer> q = new LinkedList<>(); //큐 생성 
		q.offer(v); //시작정점 v를 일단 큐에 넣음  
		visited[v] = true; // v 방문체크 
		System.out.print(v + " "); //출력 
		
		while (!q.isEmpty()) { //큐에 넣은 정점 다 돌 때까지 반복할 것 
			int p = q.poll(); //큐에서 꺼냄 
			
			for (int i=1; i<=n; i++) {
				if (graph[p][i]==1 && visited[i]==false) { //꺼낸 애랑 간선 있는 정점 있으면 
					visited[i] = true; //방문 
					System.out.print(i+" "); //출력 
					q.offer(i); //방금 다녀온 걔를 큐에 넣음  
				}
			}
			
		}
	}
	
}
