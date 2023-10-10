import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

//중복 순열
public class bj15665 {

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
		set = new LinkedHashSet<>(); // 그냥 HASHSET쓰면 정렬이 이상하게됨!!
		
		dfs(0);
		for (String a: set)
			System.out.print(a);
	}
	static void dfs(int count) {
		if (count == m) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				sb.append(temp[j]).append(" ");
			}
			sb.append("\n");
			set.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < n; i++) {
			temp[count] = nums[i];
			dfs(count + 1);
		}
	}

}

//https://hun-developer.tistory.com/38
//hashset과 LinkedHashSet, TreeSet차이점 담은 블로그!
