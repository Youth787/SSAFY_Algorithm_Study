import java.util.Arrays;
import java.util.Scanner;

public class 백트_Main15654_NM5 {
	
	static int n, m;
	static int[] nums, res;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		res = new int[m]; //result
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		dfs(0); //n개 중 m개 뽑는 순열 //사전순 나열 
	}

	static void dfs(int cnt) { 
		if (cnt==m) {
			for (int i : res) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res[cnt] = nums[i];
				dfs(cnt+1);
				visited[i] = false;
			}
		}
	}
	
}
