package p14940_쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] map;
	static int[][] distance;
	static int n;
	static int m;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isStartCheckend = false;
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        int startX = -1;
        int startY = -1;
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	if (!isStartCheckend) {
        		for (int j = 0; j < m; j++) {
        			if (map[i][j] == 2) {
        				isStartCheckend = true;
        				startX = i;
        				startY = j;
        				break;
        			}
        		}
        	}
        }
        
        bfs(startX, startY);
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0 ; j < m; j++) {
        		if (!visited[i][j] && map[i][j] == 1) {
        			sb.append(-1+" ");
        		} else {
        			sb.append(distance[i][j]+" ");
        		}
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue <Point> queue = new LinkedList<>();
		queue.add(new Point(x,y)); //add하며
		visited[x][y] = true; //방문처리
		
		while (!queue.isEmpty()) {
			Point now = queue.poll(); //꺼내
			for (int i = 0 ; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}
				queue.add(new Point(nx,ny));
				distance[nx][ny] = distance[now.x][now.y] + 1;
				visited[nx][ny] = true;
			} //델타 배열 사용한 사방탐색: 범위 내, 이동 가능 지역, 방문 전인 곳 추가
		}
	}

}
