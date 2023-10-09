import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

//HashSet이나 TreeSet이 아닌 LinkedHashSet으로 구현해야 입력순서대로 잘 출력됨  
//Set을 이용하지 않고 dfs에 int before 변수를 만들어 쓰는 방법도 있음. https://yeoncoding.tistory.com/485 
public class 백트_Main15663_NM9 {
	
	static int n,m;
	static int[] nums, res;
	static boolean[] visited; 
	static Set<String> set = new LinkedHashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		res = new int[m];
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		dfs(0);
		set.forEach(System.out::println);
	}
	
	static void dfs(int cnt) {
		if (cnt==m) {
			StringBuilder sb = new StringBuilder(); 
			for (int i:res) sb.append(i).append(" ");
			set.add(sb.toString());
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i]=true;
				res[cnt] = nums[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}
	
}
