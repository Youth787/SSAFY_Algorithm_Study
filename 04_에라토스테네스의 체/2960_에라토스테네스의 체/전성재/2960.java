import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		int arr[] = new int[n1 + 1];
		int cnt = 0;
		int ans = 0;

		for (int i = 2; i <= n1; i++) {
			if (arr[i] == 1) {
				continue;
			}// 이미 1인 경우에는 반복문을 돌릴 필요가 없다.

			for (int j = i; j <= n1; j += i) {
				if (arr[j] != 1) {//1이 아닌 경우에만 실행
					arr[j] = 1;
					cnt++;
					if (cnt == n2) {//cnt와 n2가 같을 때
						ans = j;
						break;
					}
				} else { // 이미 소수로 판명된 경우에는 pass
					continue;
				}

			}

		}
		System.out.println(ans);
	}
}
