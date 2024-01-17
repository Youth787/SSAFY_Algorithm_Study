package p7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 익은 토마토 옆 여섯 방향의 토마토가 다음날 익음 => 다 익는 날짜: 최소 일수 구하기
 * 토마토 안들어있는 칸 있을 수도. 
 * 상자 크기 M(가로)*N(세로)*H(높이)
 * 1은 익은 토마토, 0은 안익은 것, -1은 빈 곳. 
 * 
 * 저장될 때부터 모든 토마토 익어있다면 0, 토마토가 모두 익지 못한다면 -1
 * */
public class Main {
	
	static int m; //가로
	static int n; //세로
	static int h; //높이
	static int[][] box; //박스
	static int total; //토마토 개수
	static int ans;
	
	//6방향 탐색: 상,하,좌,우,윗층,아랫층
	static int[] dr;
	static int[] dc; 	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[n*h][m];
		total = 0;
		dr = new int[]{-1, 1, 0, 0, -(n+1), (n+1)};
		dc = new int[]{0, 0, -1, 1, 0, 0};
		
		for (int i = 0; i < n*h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());	
				if (box[i][j] == 0) {
					total++;
				}
			}
		} //입력, 안 익은 토마토 수 cnt 
		
		ans = 0; //며칠?
		if (total == 0) {
			ans = 0; //안 익은 토마토가 0개라면 0 출력
		} else {
			int pre = 0; //전날
			while (total != 0) {
				//토마토가 다 익을 때까지 
				chk(); //옆에 있는 토마토 익히기
				ans++; //하루 추가
				if (total > 0 && total == pre) {
					ans = -1;
					break;
				} //하루가 지났는데도 아직 안 익은 토마토 개수가 같다면 더이상 익지 못한다.
				pre = total;
			}
		}
		System.out.println(ans);		
	} //main
	
	public static void chk() {
		for (int i = 0; i < n*h; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					for (int k = 0; k < 6; k++) {
						int nr = dr[k]+i;
						int nc = dc[k]+j;
						if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
							if (box[nr][nc] == 0) {
								box[nr][nc] = 1; //익었다.
								System.out.println("["+nr+"]["+nc+"]에 있는 토마토 익었다");
								total--;
							} else if (box[nr][nc] == -1) {
								System.out.println("["+nr+"]["+nc+"]는 비어있다");
								continue; //빈 곳
							}
						}
					} //6방 탐색		
				}
			}
		} //하루 토마토 익는 과정 끝
		System.out.println(ans+"일 끝");
	}
} //class
