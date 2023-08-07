import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		int cnt = 0;
		while(N > 0) {
			arr[cnt++] = N % 10;
			N /= 10;
			
		}
		Arrays.sort(arr);
		for(int i = 9; i > 9 - cnt; i--) {
			System.out.print(arr[i]);
		}
		
	}
	
}
