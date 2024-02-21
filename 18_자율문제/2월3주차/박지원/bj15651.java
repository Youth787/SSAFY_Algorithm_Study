import java.util.*;
import java.lang.*;
import java.io.*;

// n, m 3번
class Main
{
static int n, m;
static int[] answer;
static BufferedWriter bw;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = new int[m + 1];
		
		solve(0);
		bw.flush();
		bw.close();
	}
	static void solve(int cnt) throws IOException {
		if (cnt > m) return;
		if (m == cnt) {
			for (int i = 1; i <= m; i++) {
				bw.write(answer[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			answer[cnt + 1] = i;
			solve(cnt + 1);
		}
		
		
	}
	
}
