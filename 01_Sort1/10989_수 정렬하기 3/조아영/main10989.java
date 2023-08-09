import java.util.Arrays;
import java.util.Scanner;

public class main10989 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for (int i =0; i<size; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr); //그냥 소트(퀵정렬) 
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}
	
}
