import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람
 * */
public class p1389 {
	
	static int n;
	static int [][] edge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//유저의 수
		int m = Integer.parseInt(st.nextToken());//친구 관계의 수
		edge = new int [n+1][n+1];//인접 행렬
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//A
			int b = Integer.parseInt(st.nextToken());//B
			edge[a][b] = edge[b][a] = 1;//"A와 B가 친구이면, B와 A도 친구이며" = 양방향
		}
		
		int min = Integer.MAX_VALUE;//가장 작은 케빈 베이컨 수 저장
		int ans = 0;//누군지
		
		for (int i = 1; i <= n; i++) {
			int cnt = BFS(i);
			if (cnt < min) {
				min = cnt;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}//main
	
	public static int BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean [] visited = new boolean [n+1];
		queue.add(start);
		visited[start] = true;
		int sum = 0;//케빈 베이컨 수 합
		int cnt = 0;//몇 단계?
		while (!queue.isEmpty()) {
			int size = queue.size();
      //현재 단계에 있는 모든 노드를 처리하고 다음 단계로 넘어가려고
			for (int s = 0; s < size; s++) {				
				int now = queue.poll();
				//i번 사람과 몇 단계?
				for (int i = 1; i <= n; i++) {
					if (edge[now][i] == 1 && !visited[i]) {
						visited[i] = true;
						queue.add(i);
						sum += cnt + 1;
					}
				}					
			}
			cnt++;
		}
		return sum;
	}//BFS
}//class
