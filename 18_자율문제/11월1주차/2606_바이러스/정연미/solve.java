import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스_2606 {
	static int[][] arr;
	static boolean[] visit;
	static int N, M, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i =0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			arr[b][a] = arr[a][b] = 1;
		}// 입력받기 완료 
		
		cnt=0;
		BFS(1);
		System.out.println(cnt);
		
	}// main end
	public static void BFS(int idx) {
		visit[idx] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int i =1; i<=N;i++) {
				if(arr[curr][i]==1 && !visit[i]) {
					queue.add(i);
					visit[i]= true;
					cnt++;
				}
			}
		}// while end 
		
	}// bfs method end 
}
