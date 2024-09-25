package _20240902;

import java.util.*;
import java.io.*;

public class _16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int moveCount=0;
		while(true) {
			visited = new boolean[N][N];
			boolean isMoved = false;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					// 아직 계산 안한 구역인지 확인
					if(!visited[i][j]) {
						// 한 union에 들어가는 국가들을 계산하는데,
						// sum>0은 국격이동이 있음을 알려준다
						int sum = bfs(i,j);
						if(sum>0) {
							isMoved=true;
						}
					}
				}
			}
			// 다 돌동안 국경이동이 없었으면 break, 있었다면 날짜 계산을 해준다
			if(!isMoved) break;
			moveCount++;
		}
		
		System.out.println(moveCount);
	}//main
	
	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> union = new ArrayList<>();
		
		queue.offer(new int[] {x,y});
		union.add(new int[] {x,y});
		visited[x][y] =true;
		int sum = map[x][y];
		int count =1;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			
			for(int i=0;i<4;i++) {
				int nx = curX +dx[i];
				int ny = curY +dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
					int diff = Math.abs(map[curX][curY]-map[nx][ny]);
					// 인구 이동의 대상에 포함되면
					// queue(union애 포함될 국가를 탐색하는 용도)에 추가하고
					// union(현재 같은 union인 국가들의 좌표를 리스트화한 것)에 추가하고
					// 인구를 sum에 더하고 국가 수도 카운트해준다
					if(diff>=L && diff<=R) {
						visited[nx][ny] = true;
						queue.offer(new int[] {nx,ny});
						union.add(new int[] {nx,ny});
						sum += map[nx][ny];
						count++;
					}
				}
			}
		}
		// 인구 이동이 이루어지게 되면 인구 수를 계산하여 새롭게 분배해준다
		if(count >1) {
			int newPop = sum/count;
			for(int[] pos : union) {
				map[pos[0]][pos[1]] = newPop;
			}
			return sum;
		}
		return 0;
	}//bfs

}
