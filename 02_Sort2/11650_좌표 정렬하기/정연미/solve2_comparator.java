import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class solve2_comparator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] dot = new int[T][2];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				dot[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력받기

		// 2차월 배열 정렬 0번쨰 열 다음 1번째 열 기준(다중 배열 정렬)
		Arrays.sort(dot, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { 
				// 다중 조건 
				if (o1[0] == o2[0]) { // 첫번째 열의 원소가 같을 경우 
					return o1[1] - o2[1]; // 두번째 열의 원소를 오름차순 정렬 
				} else {
					return o1[0] - o2[0]; //그렇지 않다면 첫번째 열의 원소를 오름차순 정렬 
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< T ; i++) {
			//sb.append(dot[i][0] + " " + dot[i][1]).append('\n');
			sb.append(dot[i][0] + " " + dot[i][1]+'\n');
		}
		System.out.println(sb);
		
	}//main end 
}