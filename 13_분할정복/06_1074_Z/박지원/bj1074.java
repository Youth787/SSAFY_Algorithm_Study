import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
	
	static int n, r, c, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		partition(0, 0, (int) Math.pow(2, n));
		
	}
  //그냥 무지성 돌리면 메모리초과납니당
  //r, c위치를 확인하고 1, 2, 3, 4분면 나눠서 재귀 돌리는게 포인트였던 문제입니다
	static void partition(int i, int j, int size) {
		if (size == 1) {
			System.out.println(ans);
			return;
		}
		
		int newSize = size / 2;
		if (r < i + newSize && c < j + newSize) 
			partition(i, j, newSize);
		if (r < i + newSize && j + newSize <= c) {
			ans += (size * size) / 4;
			partition(i, j + newSize, newSize);
		}
		if (i + newSize <= r && c < j + newSize) {
			ans += (size * size) / 4 * 2;
			partition(i + newSize, j, newSize);
		}
		if (i + newSize <= r && j + newSize <= c) {
			ans += (size * size) / 4 * 3;
			partition(i + newSize, j + newSize, newSize);
		}
		
	}

}
