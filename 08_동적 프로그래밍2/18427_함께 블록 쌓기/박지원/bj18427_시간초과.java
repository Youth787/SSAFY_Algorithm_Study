import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, ans;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		ans = 0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = st.countTokens();
			for (int j = 0; j < temp; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		

		combi(0, 0);
	
		
		System.out.println(ans % 10007);
		
	}
	static void combi(int idx, int height) {
		if (height > h || idx > n) return;
		if (height == h) {
			ans++;
			return;
		}

		for (int i = idx; i < n; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				combi(i + 1, height + list[i].get(j));
			}
				
		}
		
	}
}
