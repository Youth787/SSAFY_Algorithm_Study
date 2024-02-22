import java.util.*;
import java.io.*;
/*
 * n*n 땅, 각 칸은 각각 나라. 국경선 존재
 * 인구 차이가 범위 내라면 하루동안 공유하는 국경선을 연다
 * 열려야 할 국경선을 모두 열고 인구이동 시작
 * 이동가능한 경우 "연합", 연합을 이루고 있는 각 칸의 인구수 = (연합인 나라 인구 합) / (연합국 수). 소수점 버림
 * 인구 수가 주어졌을 때, 인구 이동이 며칠동안 발생하는지 구하기
 * 
 * [하루 일과] 인구 차 계산해서 국경선 열고, 연합 확인해서 인구수 다시 나누고, 연합 해체(국경선 닫기)
 */
public class Main {
	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} //Point라는 class를 만들어준다(각 국가 위치)

	static int N; //n*n
	static int L; //국경선 열지 말지 결정하는 인구 차이 범위(왼)
	static int R; //(오)
	static boolean flag; //인구 이동 발생했는지 확인
	static int[][] map; //인구 수 저장
	static boolean[][] visited; //방문처리

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 }; //하 좌 상 우

	static Queue<Point> queue; //BFS 용 queue
	static Queue<Point> tmpQueue; //연합 국가 임시 저장 용 queue

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력 끝
		
		flag = true; //더 인구이동이 남았는지 확인하는 변수
		int answer = -1;

		while (flag) {
			visited = new boolean[N][N]; //하루 시작할 때마다 방문 배열 다시 초기화해줘야 함
			flag = false; //원래 true = 오늘은 인구 이동하니까 이제 false로 바꿔놓고
			shareCountry(); //인구이동 처리. 만약 queue에 뭐가 더 들어가서 인구 이동이 발생할 수 있다면 플래그가 이 과정에서 true로 바뀔 것
			answer++; //인구이동하고 하루가 갔다

		}
		System.out.println(answer);
	} //main
	
	static void shareCountry() {
		queue = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) { //아직 방문 안한 국가라면
					queue.offer(new Point(r, c)); //bfs 탐색을 위해 queue에 추가하고
					visited[r][c] = true; //방문처리하고
					int sum = map[r][c]; //현재 국가의 인구 수로 sum을 초기화하고
					tmpQueue = new LinkedList<>(); //연합을 이루는 국가들 저장하는 queue 초기화하고
					tmpQueue.offer(new Point(r, c)); //현재 국가를 연합 큐에 추가
					bfs(sum); //bfs 갔다오면 sum 값이 이제 각 국가 인구가 연합 국 평균으로 바껴있음
				}
			}
		}
	} //shareCountry
	
	static void bfs(int sum) {
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			//사방으로 닿아있는 국가들 확인 
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) {
					continue;
				} //n*n 밖으로 넘어간 경우는 패스
				
				int val = Math.abs(map[nr][nc] - map[cur.r][cur.c]); //두 국가 간 인구 차이
				if (!visited[nr][nc] && (val >= L && val <= R)) { //인구 차이가 범위 내라면 국경선을 연다
					sum += map[nr][nc]; //연합인 나라들 인구 sum에 합침
					visited[nr][nc] = true; //방문했다
					queue.offer(new Point(nr, nc)); //bfs 탐색을 위해 queue에 추가
					tmpQueue.offer(new Point(nr, nc)); //연합에도 추가
					flag = true; //새로 넣은 값이 있으니까 다음 날도 인구이동이 발생하도록 플래그 설정

				}
			}
		}	
		int p = sum / tmq.size();
		while (!tmq.isEmpty()) {
			Point cur = tmq.poll();
			map[cur.r][cur.c] = p; //연합국 인구 평균으로 값을 바꾸는 것 = 인구 이동 처리
		} 
	} //bfs
} //class
