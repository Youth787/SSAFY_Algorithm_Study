import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int n;	
	public static int m;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new boolean[n];
        
		dfs(0); //n,m 고정이라 깊이(길이 얼마나 모였나)만 갖고 다니면 됨 
    
		System.out.println(sb);
	} //main
 
	public static void dfs(int depth) {
		if (depth == m) {
			for (int number : arr) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				
				visited[i] = false;
			}
		}
	} //dfs
 
