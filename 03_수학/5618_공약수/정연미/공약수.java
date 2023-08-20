import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공약수{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		Arrays.sort(array);

		for (int i = 1; i <= array[0]; i++) {
			int count = 0;
			for (int n = 0; n < N; n++) {
				if (array[n] % i == 0) {
					count++;
				} else {
					break;
				}
			}
			if (count == N) {
				list.add(i);
			}
		} // for end
		for (int n : list)
			System.out.println(n);
	}// main end
}
