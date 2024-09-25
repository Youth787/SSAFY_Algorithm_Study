import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int cnt = 0; // 물이 고일 수 있는 지역의 수
		int map[] = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < w - 1; i++) {
			int c = map[i]; // 현재 벽 높이
			int lmax = c; // 왼쪽 벽 최대높이
			int rmax = c; // 오른쪽 벽 최대높이

			for (int j = i - 1; j >= 0; j--) { // 왼쪽 최대벽 높이 탐색
				if (map[j] > c) {
					lmax = Math.max(lmax, map[j]);
				}
			}

			for (int j = i + 1; j < w; j++) { // 오른쪽 최대벽 높이 탐색
				if (map[j] > c) {
					rmax = Math.max(rmax, map[j]);
				}
			}

			if (Math.min(rmax, lmax) > c) { // 현재 벽보다 높은 벽이 양쪽에 있는 경우
				cnt += (Math.min(rmax, lmax) - map[i]);
			}

		}

		System.out.println(cnt);
	}

}
