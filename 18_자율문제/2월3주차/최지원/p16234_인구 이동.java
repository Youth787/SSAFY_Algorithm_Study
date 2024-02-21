import java.util.*;
import java.io.*;
/*
 * n*n 땅, 각 칸은 각각 나라. 국경선 존재
 * 인구 차이가 범위 내라면 하루동안 공유하는 국경선을 연다
 * 열려야 할 국경선을 모두 열고 인구이동 시작
 * 이동가능한 경우 "연합", 연합을 이루고 있는 각 칸의 인구수 = (연합인 나라 인구 합) / (연합국 수). 소수점 버림
 * 인구 수가 주어졌을 때, 인구 이동이 며칠동안 발생하는지 구하기
 */
public class Main {
	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} //Point라는 class를 만들어준다

	static int N; //n*n
	static int L; //국경선 열지 말지 결정하는 범위(왼)
	static int R; //(오)
	static boolean flag;
	static int[][] map;
	static boolean[][] v;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 }; //하 좌 상 우

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
			v = new boolean[N][N]; //하루마다 방문 배열 다시 만들어줘야함
			flag = false; //오늘은 인구 이동 shareCountry() 하기로 했음. 이제 false로 바꿔놓고

			shareCountry(); //만약 queue에 더 들어가서 인구 이동이 발생할 수 있다면 플래그가 이 과정에서 true로 바뀔 것
			answer++; //하루 추가

		}
		System.out.println(answer);
	} //main

	static Queue<Point> que;
	static Queue<Point> tmq;
	
	static void shareCountry() {
		que = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					que.offer(new Point(r, c));
					v[r][c] = true;
					int sum = map[r][c];
					tmq = new LinkedList<>();
					tmq.offer(new Point(r, c));
					bfs(sum);
				}
			}
		}
	} //shareCountry
	
	static void bfs(int sum) {
		while (!que.isEmpty()) {
			Point cur = que.poll();

			//사방으로 닿아있는 국가들의 인구가 
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!(nr >= 0 && nr < N && nc >= 0 && nc < N)) {
					continue;
				} //n*n 밖으로 넘어간 경우는 패스
				
				int val = Math.abs(map[nr][nc] - map[cur.r][cur.c]); //두 국가 간 인구 차이
				if (!v[nr][nc] && (val >= L && val <= R)) { //범위 내라면 국경선을 연다
					sum += map[nr][nc]; //연합인 나라들 인구 합침
					v[nr][nc] = true; //방문했다
					que.offer(new Point(nr, nc));
					tmq.offer(new Point(nr, nc));
					flag = true; //새로 넣은 값이 있으니까 다음 날도 인구이동이 발생하도록 플래그 설정

				}
			}
		}	
        	movePeople(sum);
	} //bfs

	static void movePeople(int sum) {
		int p = sum / tmq.size();
		while (!tmq.isEmpty()) {
			Point cur = tmq.poll();
			map[cur.r][cur.c] = p;
		}
	} //인구이동
} //class
