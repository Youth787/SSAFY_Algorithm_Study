package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2630_색종이만들기 {
	static int[][] arr;
	static int white_c, blue_c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		} // 입력받기 완료
		
		white_c = 0;
		blue_c = 0;
		division(0, 0, N);
		System.out.println(white_c);
		System.out.println(blue_c);
	}// main end

	public static void division(int x, int y, int size) {
		if (color(x, y, size)) {
			if (arr[x][y] == 0) white_c++;
			else blue_c++;
			return;
		}
		
		int new_size = size/2;
		division(x,y+new_size,new_size); // 1사분면 
		division(x,y,new_size);// 2사분면 
		division(x+new_size,y,new_size);//3사분면 
		division(x+new_size,y+new_size,new_size); // 4사분면 
	}

	public static boolean color(int x, int y, int size) {
		int color = arr[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] == color) continue;
				else return false;
			}
		}
		return true;
	}
}
