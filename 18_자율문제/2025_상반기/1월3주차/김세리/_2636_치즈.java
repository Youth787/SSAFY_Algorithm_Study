package _20250127;

import java.util.*;
import java.io.*;

public class _2636_치즈 {
	static int R,C, countCheese,cnt;
	static int[][] map, copyMap;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean melt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copyMap = new int[R][C];
		
		countCheese=0;
		melt=false;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				copyMap[i][j] = tmp;
				if(tmp==1) countCheese++;
			}
		}
		if(countCheese==0) {
			melt=true;
		}
		int hour=0;
		while(!melt) {
			cnt=0;
			
			meltingCheese(0,0);
			
			if(cnt>0) {
				countCheese=cnt;
				for(int i=0;i<R;i++) {
					map[i] = copyMap[i].clone();
				}
			} else {
				melt=true;
				break;
			}
			hour++;
		}
		System.out.println(hour);
		System.out.println(countCheese);
	}
	static void meltingCheese(int x, int y) {
		visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		
		visited[x][y]=true;
		if(map[x][y]==0) {
			q.add(new int[] {x,y});
		}
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<4;d++) {
				int dr = curr[0]+dx[d];
				int dc = curr[1]+dy[d];
				if(dr>=0 && dr<R && dc>=0 && dc<C && !visited[dr][dc]) {
					visited[dr][dc]=true;
					
					if(map[dr][dc]==0) {
						q.add(new int[] {dr,dc});
					}else {
						cnt++;
						copyMap[dr][dc]=0;
					}
				}
			}
		}
		
	}

}
