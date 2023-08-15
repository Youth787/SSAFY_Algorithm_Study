import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// buffer, stringtokenizer 사용. 
// hashset 사용. 중복 원소 제거 

public class Main_timeout {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 입력받을 숫자의 개수 

		int[] array = new int[T]; // 숫자를 입력받을 배열 생성 

		StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기를 기준으로 읽기 위해
		for (int i = 0; i < T; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		} // 입력 받음.

		for (int i = 0; i < T; i++) { // 하나의 원소를 잡고 
			HashSet<Integer> minSet = new HashSet<>(); // 중복 제거를 위해 HashSet 사용
			for (int j = 0; j < T; j++) { // 다른 원소들을 둘러보면서
				if (array[i] > array[j]) { // i 위치의 값보다 작은 값이 있다면 
					minSet.add(array[j]); // hashset에 담는다. (중복없이 담긴다)
				} // end if 
			} // end j for
			int num = minSet.size(); // hashset에 담긴 원소의 개수를 센다. 
			System.out.print(num+" "); // 바로 프린트 해버리기 
		} // end i for // 이 과정을 T만큼 반복해서 프린트하기 
	}// main end
}

// 시간초과가 난다.. 
