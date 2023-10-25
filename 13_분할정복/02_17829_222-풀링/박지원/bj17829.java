import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//재귀함수로 푸는거 너무 어렵다!!!!!
//한번에 돌린다는걸 생각을 못해서 접근이 어려웠다ㅠㅠ
public class bj17829 {
	
	static int n, ans; 
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		System.out.println(partition(0, 0, n));
		
		
	}
	static int partition(int r, int c, int size) { // 1, 2, 3, 4분면이 동시에 돈다고 생각하자 재귀는!!!!
		if (size == 2) { // size==2면 이제 한번만 돌면 되니까 그냥 돌고나서 출력주고 끝내기.
			int arr[] = new int[4];
			int idx = 0;
			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 2; j++) {
					arr[idx++] = map[i][j];
				}
			}
			Arrays.sort(arr); // 정렬해서 3번째수가 2번째로 큰 수
			return arr[2];
		} else { // 2보다 크다면 재귀함 더 가자
			int arr[] = new int[4];
			size = size/2;
			arr[0] = partition(r, c, size); // 1사분면
			arr[1] = partition(r, c + size, size); // 2사분면
			arr[2] = partition(r + size, c, size); // 3사분면
			arr[3] = partition(r + size, c + size, size); // 4사분면
			Arrays.sort(arr);
			return arr[2];
		}

	}
}

//https://velog.io/@gandi0330/Java-%EB%B0%B1%EC%A4%80-222-%ED%92%80%EB%A7%81-17829%EB%B2%88

