import java.util.Scanner;

public class Main {
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i =2; i<=n; i++) {
			arr[i]= i;
			}
		for(int i = 2; i<=n; i++) {
			if(arr[i]==0) continue;
			for(int j = i+i; j<=n; j+=i) {
				arr[j] = 0;
			}
		}
		for(int i = m; i<=n; i++) {
			if(arr[i]!=0) {
				System.out.println(arr[i]);
			}
		}
	}
}
