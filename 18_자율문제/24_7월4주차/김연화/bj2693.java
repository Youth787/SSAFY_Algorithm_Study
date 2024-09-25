import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// n번째 큰 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i<N; i++) {
			int[] arr = new int[10];
			for(int j = 0; j<10 ; j++) {
				int a = sc.nextInt();
				arr[j] = a;
			}
			Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}
}
