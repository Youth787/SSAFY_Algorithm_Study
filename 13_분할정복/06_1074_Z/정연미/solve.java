package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 초과 

public class _1074_Z {
	static int idx = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int R = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);
		
		int size = (int) Math.pow(2, N);
		arr = new int[size][size];
		partition(0, 0, size);
		System.out.println(arr[R][C]);
	}// main end

	public static void partition(int x, int y, int size) {
		if(size==1) {
			arr[x][y] = idx;
			idx++;
			return;
		}
		
		size = size / 2;
		partition(x, y, size);
		partition(x, y + size, size);
		partition(x + size, y, size);
		partition(x + size, y + size, size);
	}
}
