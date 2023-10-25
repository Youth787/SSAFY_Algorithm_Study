package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
 			for(int j=0; j<N; j++) 
				arr[i][j] = Integer.parseInt(input[j]);
		}// 입력받기 완료 
		
		partition(0,0,N);
	}
	public static void partition(int x, int y, int size) {
		if(check(x,y,size)) {
			if(arr[x][y]==1) System.out.print("1");
			else System.out.print("0");
			return;
		}
		
		size = size/2;
		System.out.print("(");
		partition(x,y,size);
		partition(x,y+size,size);
		partition(x+size,y,size);
		partition(x+size,y+size,size);
		System.out.print(")");
	}
	
	public static boolean check(int x, int y , int size) {
		int point = arr[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) 
				if(arr[i][j]!=point) 
					return false;
		}
		return true;
	}// method end 
}
