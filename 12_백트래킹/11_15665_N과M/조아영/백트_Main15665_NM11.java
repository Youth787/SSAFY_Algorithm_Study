import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 백트_Main15665_NM11 {

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
		dfs(0);
		//set.forEach(System.out::println); //시간초과
		StringBuilder sb = new StringBuilder();
		set.stream().forEach(i -> sb.append(i+'\n'));
		System.out.println(sb);
		
	}
	
	static void dfs(int cnt) {
		if (cnt==m) {
			StringBuilder sb = new StringBuilder();
			for (int i:res) sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		for (int i=0; i<n; i++) {
			res[cnt] = nums[i];
			dfs(cnt+1);
		}
	}
	
}
