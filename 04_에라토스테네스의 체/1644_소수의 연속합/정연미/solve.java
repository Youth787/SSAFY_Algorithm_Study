import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합 {
	static int[] array ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		array = isprime(N);
		for(int i=2; i<=N;i++) {
			if(array[i]!=0) 
				list.add(array[i]);
		}
		
		// 소수합 구하기 부분 
		int sum=0, start=0, end=0, count=0;
		while(true) {
			if(sum>=N) sum -= list.get(start++);
			else if(end == list.size()) break;
			else sum += list.get(end++);
			
			if(sum==N) count++;
		}
		
		System.out.println(count);
	}// main end

	static int[] isprime(int n) {
		array = new int[n + 1];
		array[0] = 0;
		array[1] = 0;

		for (int i = 2; i <= n; i++) 
			array[i] = i; // 배열을 초기화한다.

			for (int i = 2; i <= n; i++) {
			if (array[i] == 0) 
				continue;
			for (int j = 2 * i; j <= n; j += i) 
				array[j] = 0;
		}
		return array;
	}// method end
}
