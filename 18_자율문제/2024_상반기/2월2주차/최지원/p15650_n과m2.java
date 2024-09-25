import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int[] arr;
	static int n;
  static int m;
	static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
        
		dfs(1, 0);
		System.out.println(sb);
 
	} //main
 
	public static void dfs(int at, int depth) {
 
		if (depth == m) {
			for (int number : arr) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}
        
		for (int i = at; i <= n; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	} //dfs
} //class
