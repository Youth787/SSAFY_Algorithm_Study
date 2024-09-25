//package p11123_양한마리양두마리;
// https://www.acmicpc.net/problem/11123
//문제: 양을 #으로, 풀을.으로 표현했을 때 몇개의 양 무리가 있었는지 출력

//고민한 부분1: BFS에서 방문처리하면서 queue에 넣을 친구가? => sheep이라는 새로운 객체(r,c를 가지는)를 만들어서 넣었다
//고민한 부분2: 양 무리의 수를 세야 하는데 어디서 시작하고 어느 타이밍에 카운트를 해야 하는지? => 아직 방문처리 안한 양을 발견했을 때 cnt하고, 그 자리부터 확인하면서 같은 무리 다른 양들을 방문처리한다 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int h, w, cnt;//h는 그리드 높이. w는 그리드 너비, cnt는 양 무리
	static int [][] arr;
	static boolean [][] visited;
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	static Queue <sheep> queue;	
	
	public static class sheep {
		int r, c;	
		public sheep(int r, int c) {
			this.r = r;
			this.c = c;			
		}		
	}//sheep
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());//t
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());//h는 그리드 높이
			w = Integer.parseInt(st.nextToken());//w는 그리드 너비
			arr = new int [h][w];
			visited = new boolean [h][w];			
			for (int i = 0; i< h; i++) {
				String tmp = br.readLine();
				for (int j=0; j<w; j++) {
					if (tmp.charAt(j) == '#') arr[i][j] = 1;
					else {
						arr[i][j] = 0;
						visited[i][j] = true;//어짜피 고려할 필요가 없는 위치니까 방문했다고 처리
					}
				}
			}//입력 완
			
			cnt = 0;//양 무리 수(답)

			for (int i = 0; i< h; i++) {
				for (int j=0; j<w; j++) {
					if (!visited[i][j]) {
						cnt++;
						BFS(i,j);//같은 무리에 속하는 양들을 방문처리하는 과정
					}				
				}
			}
			
			System.out.println(cnt);		
		}//tc		
	}//main
	
	public static void BFS (int r, int c) {			
		queue = new LinkedList<>();//큐 생성, 무리별로 하나의 큐를 사용한다고 생각
		queue.add(new sheep(r,c));//시작점 넣기
		visited[r][c] = true;//(처음 시작 양)방문했다
		while (!queue.isEmpty()) {//연결되는 양들을 모두 처리할꺼야
			sheep t = queue.poll();//큐에 들어있는(연결된 양)꺼내
			for (int i=0; i<4; i++) {
				int nr = t.r + dr[i];
				int nc = t.c + dc[i];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc]) {
					visited[nr][nc] = true;//방문처리
					queue.add(new sheep(nr,nc));
				}
			}//사방을 확인하면서 양이 있는곳은 방문처리하고 그 좌표를 큐에 add
		}	//같은 무리의 양 방문처리..큐에 아무것도 남지 않을때까지
	}//BFS
}//class
