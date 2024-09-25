package _11월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시그널 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		String[][] arr = new String[5][s.length/5];
		
		for(int i=0; i<5;i++) {
			for(int j=0; j<s.length/5; j++) {
				arr[i][j] = s[i*(s.length/5)+j];
			}
		}// 입력받기 완료 
		
		// 어떻게 구현하지 
		
	}// main end
}
