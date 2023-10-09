import java.util.Arrays;
import java.util.Scanner;

public class 백트_Main15656_NM7 {

	static int n,m;
	static int[] nums,res;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		res = new int[m];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		dfs(0,0); //중복순열 
		System.out.println(sb);
	}

	static void dfs(int cnt, int st) {
		if (cnt==m) {
			for (int i:res) sb.append(i).append(" ");
			sb.append("\n");
//			for (int i:res) System.out.print(i+" ");
//			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			res[cnt] = nums[i];
			dfs(cnt+1,i);
		}
	}

}
