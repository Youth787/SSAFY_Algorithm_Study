import java.util.*;

public class Main10971_외판원순회2 {

	static int n, ans;
	static int[][] w;
	static boolean[] visited;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n개의 도시 
		
		w = new int[n][n]; //각 간선의 가중치 (비용) 
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				w[i][j] = sc.nextInt();
			}
		}
		
		//최소 비용 신장 트리 (MST) : 크루스칼, 프림 알고리즘  
		//모든 노드를 방문하고, 사이클이 없어야 한다 
		//사용된 간선들의 가중치 합이 최소인 트리 
		
		//그냥 완탐해보자 
		
		ans = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			visited[i] = true; //i번째 노드부터 방문 
			backtracking(i,i,0,0); 
		}
		
		System.out.println(ans);
		
	}
	
	//시작점, 현재지점, 합, 개수 
	private static void backtracking(int st, int cur, int sum, int cnt) {
		if (cnt==n-1) { //모든지점 방문 시
			 if (w[cur][st] != 0) { //(맨 마지막에 원래 도시로 돌아와야 하므로) 끝점과 시작점이 이어져 있으면 
				 sum += w[cur][st]; //해당 간선 가중치 더해주고 
				 ans = Math.min(ans, sum); //기존 결과와 비교 
			 }
			 return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i] && w[cur][i]!=0) { //아직 방문 안 했고 간선 있으면 
				visited[i] = true; //방문해서 
				backtracking(st, i, sum+w[cur][i], cnt+1); //그 다음 지점 가야 하니까 재귀 호출 
				visited[i] = false; //갔다가 돌아와서 다른 경로로 다시 해봐야 하니까 다녀오면 false로 돌려줘야 함 
			}
		}
		
		
		
	}
	
}
