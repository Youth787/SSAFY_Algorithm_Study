import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복을 허용하지 않는 순열 
// nPr

public class Main {
	static int N, M;
	static int[] result;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 입력받기 완료 
		result = new int[M]; // 결과를 담을 배열  
		visit = new boolean[N];
		
		DFS(0);
	}// main end
	
	static void DFS(int depth) {
		if(depth==M) {
			for(int a : result) 
				System.out.print(a+" ");
			System.out.println();
			return;
		} // 기저파트 
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) { 
				visit[i] = true; // 해당 노드 방문 상태를 설정 
				result[depth] = i+1; // i+1값을 저장 
				DFS(depth+1); // 다음 자식 노드 방문을 위해 재귀 호출 
				visit[i]=false; // 자식 노드 방문 끝나고 방문노드를 방문하지 않은 상태로 돌려놓기. 
			}
		}
	}// method end
}

