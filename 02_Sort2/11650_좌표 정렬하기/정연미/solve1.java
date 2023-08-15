import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve1 {
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

		for(int i =0;  i<T-1; i++){
			int min_idx = i;
			for(int j=i+1; j<T;j++) {
				if(dot[min_idx][0]>dot[j][0]) {
					min_idx = j;
				}
			}
			swap(dot,i, min_idx);
		} // 선택정렬 

		for(int i=0; i<T-1; i++) {
			if(dot[i][0]==dot[i+1][0]) {
				if(dot[i][1]>dot[i+1][1]) {
					swap(dot,i,i+1);
				}
			}
		} // 두번째 열 정렬 
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< T ; i++) {
			sb.append(dot[i][0] + " " + dot[i][1]).append('\n');
		}
		System.out.println(sb);
	}// main end
	
	public static void swap(int[][] array, int i, int min_idx) {
		int[] tmp = array[i];
		array[i] = array[min_idx];
		array[min_idx] = tmp;
	}
	
	// Buffer와 stringbuilder를 사용했지만, 시간초과가 난다. 
	// sort 부분에서 선택정렬법을 사용했는데, 시간초과가 나지 않기 위해 
	// 2차원 배열에서의 arrays.sort 사용법을 새로 공부하기로. 

}
