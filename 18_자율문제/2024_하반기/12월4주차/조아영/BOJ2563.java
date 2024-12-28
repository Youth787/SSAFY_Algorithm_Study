import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		boolean[][] arr = new boolean[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
      int ans = 0;
			for (int j = x; j < a+10; j++) {
				for (int k = y; k < b+10; k++) {
					arr[j][k] = true;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j]) ans++;
			}
		}
		System.out.println(ans);
	}
}
