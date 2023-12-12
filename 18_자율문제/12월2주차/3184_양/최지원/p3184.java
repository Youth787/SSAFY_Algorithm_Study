import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 마당은 행과 열로 이루어진 직사각형 모양이다. 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대
 * 처음에 먼저 양 전체 수, 늑대 전체 수 적어두고
 * bfs 하면서, # 울타리 안에서 양이랑 늑대 수 카운트해서 비교
 * 양이 더 많으면 늑대 수에서 울타리 안 늑대 빼기
 * */
public class p3184 {
	public static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;			
		}
	}
	static int r, c, s, w;
	static char [][] yard;
	static boolean [][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		s = 0;
		w = 0;
		yard = new char [r][c];
		visited = new boolean [r][c];
		//입력
		for (int i = 0; i < r; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < c; j++) {
				yard[i][j] = tmp.charAt(j);
				if (yard[i][j] == 'o') {
					s++;
				} else if (yard[i][j] == 'v') {
					w++;
				} else if (yard[i][j] == '#') {
					visited[i][j] = true;
				} 
			}		
		}//입력 완
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j]) {
					BFS(i, j);
				}
			}
		}
		
		System.out.println(s+" "+w);
	}//main
	
	public static void BFS(int nowR, int nowC) {
	    int sheep = 0;
	    int wolf = 0;

	    Queue<Point> queue = new LinkedList<Point>();
	    queue.add(new Point(nowR, nowC));
	    visited[nowR][nowC] = true;

	    while (!queue.isEmpty()) {
	        Point p = queue.poll();

	        //지금 울타리 안의 양, 늑대 수 체크
	        if (yard[p.r][p.c] == 'o') {
	            sheep++;
	        } else if (yard[p.r][p.c] == 'v') {
	            wolf++;
	        }

	        for (int i = 0; i < 4; i++) {
	            int nr = p.r + dr[i];
	            int nc = p.c + dc[i];
	            //마당 범위 내, 방문 전, 울타리 아닌 곳
	            if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && yard[nr][nc] != '#') {
	                visited[nr][nc] = true;
	                queue.add(new Point(nr, nc));
	            }
	        }
	    }

	    if (wolf >= sheep) {
	        s -= sheep;
	    } else {
	        w -= wolf;
	    }
	}//BFS
	
}//class
