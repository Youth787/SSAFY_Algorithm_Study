import java.util.Scanner;

public class Main {

	static int N;
	static int[][] array;
	static boolean visited[];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				array[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true; // 시작 지점 방문처리
			DFS(i, i, 0, 0);
			visited[i] = false; // 시작 지점 초기화
		}

		System.out.println(answer);
	}

	public static void DFS(int start, int now, int sum, int cnt) {
		if (cnt == N - 1) {
			if (array[now][start] != 0) {
				sum += array[now][start];
				if (sum < answer)
					answer = sum;
			} // 마지막 도착지 더하고 나오기
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == false && array[now][i] != 0) {
				visited[i] = true; // 방문 처리
				DFS(start, i, sum + array[now][i], cnt + 1);
				visited[i] = false; // 방문 지점 초기화
			}
		}
	}

}
