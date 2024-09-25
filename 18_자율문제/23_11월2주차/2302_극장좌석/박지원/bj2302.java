import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2302 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 좌석갯수
		int m = Integer.parseInt(br.readLine()); // 고정석갯수
		//양옆에도 앉기 가능인데 vip는 자기자리를 앉아야함
		//앉을수있는 경우의수는 ?
		boolean[] seat = new boolean[n + 1]; // 0번빼고, 고정석이면 true 아니면 false로 표시
		int[] rule = new int[41]; // 규칙성을 담을 배열 rule[i] = j >> i: 고정석뺀 자리가 i개면 j만큼의 가짓수가 가능!
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(br.readLine());
			seat[a] = true; // 고정석 true처리
		}
		rule[0] = 1; // 안쓸건데, 정답에 곱해줄거라서 0아닌 1로 초기화 >>0 으로하면 틀려용
		rule[1] = 1;
		rule[2] = 2;
		for (int i = 3; i <= n; i++) { // 점화식에 따라 rule을 채워준다.
			rule[i] = rule[i - 1] + rule[i - 2];
		}
		long ans = 1;
		int count = 0;
		for (int i = 1; i <= n; i++) { // 1~n자리까지 돌면서 각각 갯수가 몇개인지 파악하여 곱해주면 답!
			if (seat[i]) {
				ans *= rule[count];
				count = 0;
			} else if (i == n) {
				count++;
				ans *= rule[count];
			} else {
				count++;
			}
			
		}
		System.out.println(ans);
	}
}
//123
//132
//213 >> 3
//1234
//2134
//2143
//1243
//1324 >> 5
//12345
//21345
//21435
//21354
//13245
//13254
//12435
//12354 >> 8
//6자리일땐 5+8 이런 규칙이 있따!!!!
