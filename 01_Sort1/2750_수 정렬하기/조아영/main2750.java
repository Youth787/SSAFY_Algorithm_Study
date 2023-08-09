import java.util.Arrays;
import java.util.Scanner;

public class main2750 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for (int i=0; i<size; i++) {
			arr[i] =sc.nextInt();
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (arr[i]!=arr[j] && arr[i]<arr[j]) { //선택정렬
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
//					System.out.println(Arrays.toString(arr));
				}
			}
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

}