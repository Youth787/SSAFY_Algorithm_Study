package _20250422;

import java.util.*;
import java.io.*;

public class _14267_회사문화1 {
	static int n,m;
	static int[] compliment;
	static List<List<Integer>> tree = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i=0;i<=n;i++) {
			tree.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i=2;i<=n;i++) {
			int boss = Integer.parseInt(st.nextToken());
			tree.get(boss).add(i);
		}
		compliment = new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			compliment[a] +=w;
		}
		dfs(1);
		//		System.out.print(tree);
		for(int i=1;i<=n;i++) {
			System.out.print(compliment[i]+" ");
		}
	}
	public static void dfs(int curr) {
		for(int next : tree.get(curr)) {
			compliment[next] +=compliment[curr];
			dfs(next);
		}
	}

}
