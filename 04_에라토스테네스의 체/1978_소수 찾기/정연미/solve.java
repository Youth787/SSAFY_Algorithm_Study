import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 주어진 수 N개의 숫자 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

public class 소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (check(array[i])) 
				result.add(array[i]);
		}
			System.out.print(result.size());
	}// main

	public static boolean check(int n) {
		if(n==1) 
			return false;
		
		for (int i = 2; i < n; i++) {
			if (n%i==0) 
				return false;
		} return true;
	}// method end
}
