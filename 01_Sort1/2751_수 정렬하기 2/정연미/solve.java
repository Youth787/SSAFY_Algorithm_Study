import java.util.Arrays;
import java.util.Scanner;

public class 수_정렬하기_2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 int N = Integer.parseInt(br.readLine()); // br로 한줄씩 읽고, 정수로 변환. 
//		 StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄씩 읽고 공백단위로 끊어준다. 
//		 ex) arr[j] = Integer.parseInt(st.nextToken());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 숫자를 담을 배열을 생성한다.
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
