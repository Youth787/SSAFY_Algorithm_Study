import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, num;
	static char[] nArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			int[] numArr = new int[num];
			nArr = br.readLine().toCharArray();
			for (int k=0;k<num;k++) {
				numArr[k] = nArr[k] - '0';
			}
			char[] arr = br.readLine().toCharArray();
			
			int result = 0;
			for (int j = 0; j < num; j++) {
				if (j == 0) {
					if (numArr[j] != 0 && numArr[j + 1] != 0) {
						numArr[j]--;
						numArr[j + 1]--;
						result++;
					}
				} else if (j == num - 1) {
					if (numArr[j - 1] != 0 && numArr[j] != 0) {
						numArr[j]--;
						numArr[j - 1]--;
						result++;
					}
				} else {
					if (numArr[j - 1] != 0 && numArr[j] != 0 && numArr[j + 1] != 0) {
						numArr[j - 1]--;
						numArr[j]--;
						numArr[j + 1]--;
						result++;
					}
				}
			}

			System.out.println(result);
		}

	}
}
