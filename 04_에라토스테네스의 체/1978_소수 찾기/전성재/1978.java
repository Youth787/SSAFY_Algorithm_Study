import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n];
		int ans = 0;
		Arrays.sort(arr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 배열에 넣기

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			if (arr[i] == 1) {
				continue;
			} else {
				for (int j = 2; j <arr[i]; j++) {//2부터 자신-1까지의 수만큼 나누기
					if (arr[i] % j == 0) {
						cnt++;
					}
				}
				if(cnt==0) {
					ans+=1;
				}
			}

		}
		System.out.println(ans);
	}
}
