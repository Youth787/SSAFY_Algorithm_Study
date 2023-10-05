
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
 
	static int[] arr;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
 
		arr = new int[m];
        
		DFS(1, 0);
		System.out.println(sb);
 
	}
 
	public static void DFS(int at, int depth) {
		//기저조건 m에 도달 ?: 출력후 return
		if (depth == m) {
			for (int nn : arr) {
				sb.append(nn).append(' ');
			}
			sb.append('\n');
			return;
		}
        
		for (int i = at; i <= n; i++) {
 
			arr[depth] = i;
			DFS(i + 1, depth + 1);
 
		}
	}
}
