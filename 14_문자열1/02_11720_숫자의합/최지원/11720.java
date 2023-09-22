import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char [] tmp = sc.next().toCharArray();
		int [] nums = new int[n];
		for (int i = 0; i< n; i++) {
			nums[i] = tmp[i] - '0';
		}
		int ans = 0;
		for (int nn : nums) {
			ans += nn;
		}
		System.out.println(ans);
	}//main
}//class
