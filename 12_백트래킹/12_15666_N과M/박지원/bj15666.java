import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

//중복 조합
public class bj15666 {

	static int n, m;
	static int[] nums, temp;
	static HashSet<String> set;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		temp = new int[m];
		set = new LinkedHashSet<>();
		
		dfs(0, 0);
		for (String a: set)
			System.out.print(a);
	}
	static void dfs(int idx, int count) { // 조합이니까 idx랑 depth두개 들고가깅
		if (count == m) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				sb.append(temp[j]).append(" ");
			}
			sb.append("\n");
			set.add(sb.toString());
			return;
		}
		if (idx >= n) return;
		
		temp[count] = nums[idx]; 
		dfs(idx, count + 1); // 골랐을때 (다음인덱스로 안넘어가고(중복조합이니까!), 골랐으니까 count+1)
		dfs(idx + 1, count); // 이번 idx안골랐을때 (다음인덱스로 넘어가주고, count는 그대로)

	}
}
