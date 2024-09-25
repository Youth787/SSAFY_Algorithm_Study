package p2667_단지번호붙이기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * 1(집), 0(x) 지도로 단지 정의하고 번호 붙이기
 * 연결 = 상하좌우 다른 집 있는 경우
 * 단지 수와 각 단지 속하는 집의 수 오름차순으로 정렬해 출력
 * 
 * */

/*
 * [풀이 순서]
 * main에서 0,0부터 for문을 2중으로 돌면서 1을 찾는다
 * 아직 방문 안한 1 찾으면 dfs 호출
 *
 * <dfs>
 * stack을 만들고 해당 좌표를 stack에 넣는다 (push)
 * 이때 방문처리!!!!!!
 * stack.isEmpty 될때까지 while문 돌면서
 * stack에서 하나를 뺀다 (pop)
 * 이 때 cnt++ !!!
 * 빼낸 값과 dr dc 이용해서 범위를 벗어나지 않고, 방문 전이고, 1인 곳을 찾아서 stack에 넣는다 (push)
 * while문에서 빠져나왔다면 cnt값을 ans에 추가
 * */

public class Main {
	static int n; //n*n 지도 사이즈
	static int[][] map; //지도
	static boolean[][] visited; //지도
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int sum = 0;
	static ArrayList<Integer> ans = new ArrayList<>(); //답 모아놓기
	
	public static class Point {
		int r;
		int c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} //항상 실수 나온 부분: (클래스 이름은 대문자로 시작,) Main 클래스의 외부에서 정의해주거나, 내부에서 정의하되 static을 붙여줘야함
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tmp.substring(j, j+1));
			}			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
				}
			}
		}
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for (int i : ans) {
			System.out.println(i);			
		}
	} //main
	
	//stack 사용한 dfs 할때 => 시작점 stack에 push > 방문처리 > pop하면서 cnt > 사방탐색하며 조건 맞으면 또 push > 방문처리
	static void dfs(int nowR, int nowC) {
		Stack <Point> stack = new Stack<>();
		sum = 0;
		stack.push(new Point(nowR, nowC));
		visited[nowR][nowC] = true; //방문처리
		while (!stack.isEmpty()) {
			Point now = stack.pop(); //꺼내고
			sum++; //단지카운트
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && map[nr][nc] == 1) {
					stack.push(new Point(nr,nc));
					visited[nr][nc] = true; //방문처리
				} 
			}
		}
		ans.add(sum);
	} //dfs
} //class
