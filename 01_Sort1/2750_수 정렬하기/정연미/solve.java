import java.util.Arrays;
import java.util.Scanner;

public class solve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력받을 숫자의 개수
		int N = sc.nextInt();
		
		//숫자를 담을 배열을 생성한다. 
		int[] array = new int[N];
		
		for(int i =0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		
		//배열을 오름차순으로 정렬시켜주는 메소드 
		Arrays.sort(array);
		
		for(int i : array) {
			System.out.println(i);
		}
		sc.close();	
		
	}
}
