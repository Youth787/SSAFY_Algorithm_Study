package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _17829_222_풀링 {
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}// 입력받기 완료 
		
		System.out.println(division(0,0,N));
	}// main end 
	public static int division(int x, int y, int size) {
		if(size == 2) {
			int[] map = new int[4];
			int idx =0;
			
			for(int i=x; i<x+2;i++) 
				for(int j=y; j<y+2;j++) 
					map[idx++] = arr[i][j];
			
			Arrays.sort(map);
			return map[2];
		}
		
		else {
			int[] map = new int[4];
			size = size/2;
			
			map[0] = division(x,y,size);
			map[1] = division(x,y+size,size);
			map[2] = division(x+size,y,size);
			map[3] = division(x+size,y+size,size);
			
			Arrays.sort(map);
			return map[2];
		}
	}// method end
}
