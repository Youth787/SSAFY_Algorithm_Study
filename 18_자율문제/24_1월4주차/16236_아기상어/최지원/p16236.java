package p16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * n*n 에 물고기 m 마리, 아기상어(처음 크기 2) 한마리
 * 아기상어는 1초에 상하좌우 인접한 한칸씩 이동
 * 상어 이동은 자기보다 작거나 같은 크기 물고기있는 곳 가능. 
 * 먹는건 자기와 가장 가까운, 자신보다 작은 물고기. (거리=지나가는 칸 개수 최소값)(가장 위에 있고 -> 가장 왼쪽에 있는 물고기)
 * 아기상어 크기와 같은 수의 물고기를 먹을때마다 크기 1 증가.
 * 
 * 입력: 0은 빈칸, 1,2,3,4,5,6 물고기 크기, 아기상어 위치=9
 * 출력: 아기상어가 몇 초동안 물고기를 먹을 수 있는지
 * 
 * BFS를 
 * */
public class Main {
	
	//아예 비교 기준을 좌표 클래스에 넣어버리자
	//가장 가까운, 자기보다 작은 물고기. 만약 여러개면 가장 위에, 그래도 많으면 가장 왼쪽
	static class point implements Comparable<point> {
		int r; //행
		int c; //열
		int size; //아기상어 사이즈
		int distance; //이동거리
		public point(int r, int c, int size, int distance) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(point o) {
		    if (this.distance != o.distance) {
		        return this.distance - o.distance; // 거리 순으로 정렬
		    } else if (this.r != o.r) {
		        return this.r - o.r; // 거리가 같으면 더 위에 있는 순서
		    } else {
		        return this.c - o.c; // 위치가 같으면 더 왼쪽에 있는 순서
		    }
		}
	} //물고기 좌표
	
	static int n; //전체 공간 크기
	static int[][] sea; //전체 공간
	static boolean[][] visited; //전체 공간 방문처리
	static int time; //정답(물고기 잡아먹을 수 있는 시간)
	static int cnt; //얼마나 먹었나(shark와 같아지면 다시 0으로, shark와 time는 +1)
	static int shark = 2; //아기상어 크기
	static int nowR;
	static int nowC; //상어 위치
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1}; //델타 상하좌우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sea = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for (int j = 0; j < n; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					nowR = i;
					nowC = j; //현재 아기상어 위치 저장
					sea[i][j] = 0; //상어 있던 곳 0 처리
				} 
			}			
		} //입력 완료
		cnt = 0;
		time = 0; //변수 초기화
				
		//현재 아기상어의 상하좌우에 아기상어보다 작거나 같은 칸이 있다면 이동 nowR,nowC 이동
		//만약 작으면 먹어서 cnt++,  sea[해당 위치] = 0, 
		/*
		 * 반복문 속에
		 * 방문배열을 초기화하고, BFS를 돌림
		 * BFS의 결과는 다음에 먹을 수 있는 가장 우선순위가 높은 물고기의 위치를 반환함(없으면 null)
		 * null 반환되었으면 이제 엄마 호출하니까 지금까지의 time 출력
		 * 그게 아니라면 우선순위 물고기의 위치까지 갔다고 치고, 
		 * 현재 아기상어 위치를 반환값의 r,c로 옮기고 + 그자리의 값을 0으로 바꾸고 + 하나 먹은거니까 cnt++ (+ 상어 레벨업 해야하나 확인)
		 * 
		 * distance는 BFS에서 인접 칸 이동시마다 +1되고, 시작점에서 해당 좌표까지 이동하는 최소 이동 횟수(시간)이 저장되어 있는거
		 * */
		for ( ; ; ) {
			visited = new boolean[n][n]; //방문배열 초기화
			point search = BFS(new point(nowR, nowC, shark, time));
			if (search == null) { //먹을 물고기 없어서 엄마 소환
				System.out.println(time);
				return; //무한루프 끝
			}
			
			nowR = search.r;
			nowC = search.c; //BFS 후 위치 저장
			sea[nowR][nowC] = 0; //여기 있는 물고기 먹었으니까 0 처리
			cnt++;
			if (cnt == shark) {
				shark++;
				cnt = 0;
			} //상어 레벨업
			time = search.distance;
		}
		
		
	} //main
	
	public static point BFS(point start) {
		Queue <point> queue = new LinkedList<>();
		ArrayList <point> list = new ArrayList<>();
		queue.add(start); //queue에 넣고
		visited[start.r][start.c] = true; //방문처리
		
		while (!queue.isEmpty()) {
			point tmp = queue.poll(); //하나 완전히 꺼내서
			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i]; //델타 사용해서 위치 조정
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || tmp.size < sea[nr][nc]) {
					continue;
				} //범위 밖이거나, 방문 이미 한 곳이거나, 크기가 커서 못먹는 친구
				visited[nr][nc] = true; //이동 가능한 곳이면 방문처리하고
				queue.add(new point(nr, nc, tmp.size, tmp.distance+1)); //queue에 넣음
				if (sea[nr][nc] != 0 && tmp.size > sea[nr][nc]) {
					list.add(new point(nr, nc, tmp.size, tmp.distance+1)); //멋을 수 있는 거면 list에
				}
			}
		}
		
		Collections.sort(list); //먹을 수 있는 물고기들 정렬=>point class에 만든 기준대로 정렬
		return list.isEmpty() ? null : list.get(0); //정렬하면 가장 먼저인 물고기가 0에 저장되어있음
	} //BFS
	
} //class
