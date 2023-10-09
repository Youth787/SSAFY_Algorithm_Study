import java.util.Arrays;
import java.util.Scanner;

public class 백트_Main15657_NM8 {

	static int n,m;
	static int[] nums,res;
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
		dfs(0,0); //중복조합 
	}
	
	static void dfs(int cnt, int st) {
		if (cnt==m) {
			for (int i:res) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=st; i<n; i++) {
			res[cnt] = nums[i];
			dfs(cnt+1,i);
		}
	}
	
}
