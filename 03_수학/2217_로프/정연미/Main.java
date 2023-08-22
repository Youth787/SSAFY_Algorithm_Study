import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		int[] result = new int[N];

		for(int i =0 ;i<N; i++) {
			result[i] = array[i]*(N-i);
		}
		
		Arrays.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result[result.length - 1]);
		System.out.println(sb);
	}// main end
}