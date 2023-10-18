//이렇게 풀고 싶었다...혼자 풀기 실패
package p1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//뭔가 for문을 돌면서. 1을 만났을 때. 거기서부터 정사각형 범위만큼 넓혀가면서 모두 1인지 확인하는 과정. 0을 만나면 그 전까지의 값
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean [][] arr = new boolean [n][m];//n*m의 0과 1로 된 배열이 있다
		
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				if (tmp.charAt(j) == '1') arr[i][j] = true;
				//아니면 뭐 기본 값 그대로 false
			}
		}//입력 완
		
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j]) { //1이면 (true면)
					for (int k = 1; k < Math.min(n-i, m-j); k++) { //지금 위치 i에서 n-1까지 남은 거리와 반대 경우에서 더 작은만큼 정사각형이 만들어질수도 있으니까
						//정사각형 탐색...어쩌구...
					}
				}
			}
		}
		
		System.out.println(ans);
	
	}//main
}//class
