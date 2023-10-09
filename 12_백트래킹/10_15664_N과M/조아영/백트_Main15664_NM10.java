import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 백트_Main15664_NM10 {
	
	static int n,m;
	static int[] nums,res;
	static Set<String> set = new LinkedHashSet<>();
	
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
		dfs(0,0);
		set.forEach(System.out::println);
	}
	
	static void dfs(int cnt, int st) {
		if (cnt==m) {
			StringBuilder sb = new StringBuilder();
			for (int i:res) sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		for (int i=st; i<n; i++) {
			res[cnt] = nums[i];
			dfs(cnt+1,i+1);
		}
	}
	
}
