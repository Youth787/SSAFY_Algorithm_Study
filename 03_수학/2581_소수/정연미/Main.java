import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input = new int[2];
		input[0] = Integer.parseInt(br.readLine());
		input[1] = Integer.parseInt(br.readLine());
		Arrays.sort(input);

		List<Integer> onelist = new ArrayList<>();

		for (int i = input[0]; i <= input[1]; i++) {
			if (isPrimeNumber(i)) {
				onelist.add(i);
			}
		}

		if (onelist.size() == 0) { // 소수가 없으면
			bw.write(String.valueOf(-1));
		} else { // 있다면
			Collections.sort(onelist);
			int sum = 0;
			for (int i = 0; i < onelist.size(); i++) {
				sum += onelist.get(i);
			}
			// 더하기 출력
			bw.write(String.valueOf(sum) + "\n");
			// 최소값 출력
			bw.write(String.valueOf(onelist.get(0)));
		}
		br.close();
		bw.flush();
		bw.close();

	}// main end

	private static boolean isPrimeNumber(int targetNumber) {
		if(targetNumber ==1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(targetNumber); i++) {
			if (targetNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
}
