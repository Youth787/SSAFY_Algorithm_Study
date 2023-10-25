import java.util.Scanner;

public class Main1789_수들의합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		
		long sum = 0;
		long cnt = 1; 
		while (sum<S) {
			sum = sum+cnt; 
			cnt++;
		}
		
		if (sum==S) System.out.println(cnt-1);
		else System.out.println(cnt-2);
		
		//서로 다른 N개의 자연수의 합이 S이다. S가 주어질 때 N의 최댓값은 ? 
		//의외로 간단한 문제! 1부터 차례로 더해가서, S보다 큰 수가 되었을 때 count-1 
		//아래와 같이 해도 됨 
//		long sum = 0;
//		long cnt = 0; 
//		for (int i=1; ; i++) {
//			if (sum>S) break;
//			sum+=i; 
//			cnt++;
//		}
//		System.out.println(cnt-1);
		
	}
	
}
