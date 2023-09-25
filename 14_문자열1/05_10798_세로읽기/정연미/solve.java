import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[5][15];
		
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				arr[i][j] = s.charAt(j); 
			}
		}// 입력받기 완료 
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) 
				if(arr[j][i]==0) 
					continue;
				else System.out.print((char)arr[j][i]);
		}
	}
}
