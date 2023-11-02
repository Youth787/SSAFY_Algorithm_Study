package _11월1주차문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 맥주마시면서걸어가기_9205 {
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+2][2];
			for(int i=0; i<N+2; i++) {
				String[] input = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(input[0]);
				arr[i][1] = Integer.parseInt(input[1]);
			}//입력받기 
			
			int check =0;
			for(int i=0; i<N+1; i++) {
				check += 1000 - distance(i,i+1);
				if(check<0) {
					System.out.println("sad");
					return;
				}
			}
			System.out.println("happy");
		}// test case end 
	}// main end
	public static int distance(int x, int y) {
		return (int) Math.sqrt(Math.pow((arr[x][0] - arr[y][0]) , 2) + Math.pow((arr[x][1] - arr[y][1]) , 2)); 
	}
}
