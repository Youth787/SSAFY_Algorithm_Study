package _20240723;

import java.util.*;
import java.io.*;

public class _7569_토마토 {
	static int M,N,H, ans=0;
	static int[][][] box;
	static Queue<int[]> q = new LinkedList<>();
	
	// 위, 아래, 앞, 뒤, 왼, 오
	static int[] dx = {0,0,0,0,-1,1};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {-1,1,0,0,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					box[k][i][j]=tmp;
					
					// 익은 토마토 좌표 저장
					if(tmp==1) q.add(new int[] {k,i,j});
				}
			}
		}
		// 이미 전부 익은 상태라면 0
		if(allTomatoesRipe()) {
			ans=0;
		}
		// 아닐땐 bfs돌린다
		else {
			ans = bfs();
		}
		System.out.println(ans);
		
	}//main
	
	static boolean allTomatoesRipe() {
		for(int z=0;z<H;z++) {
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					// 0인게 하나라도 있으면 false반환
					if(box[z][x][y]==0) {
						return false;
					}
				}
			}
		}
		return true;
		
	} // allTomatoesRipe
	
	static int bfs() {
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int z = current[0]; int x = current[1]; int y = current[2];
			
			for(int i=0;i<6;i++) {
				int nz = z+dz[i];
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nz>=0 && nz<H && nx>=0 && nx<N && ny>=0 && ny<M && box[nz][nx][ny] == 0) {
					// 익지 않은 토마토일 경우 익은 것으로 표시하고,
					// q에 익은 토마토로 추가한다
					// 1이었던 것에 1을 더해서 수를 바꿔준다(며칠이 지났는지 표시가능)
					// 기존에 익은 토마토로 있었던건 어차피 이제 주변이 익은 토마토이므로 추가할 필요 없다
					box[nz][nx][ny] = box[z][x][y] + 1;
					q.add(new int[] {nz, nx, ny});
				}
			}
		}
		
		int max=0;
		for(int z=0;z<H;z++) {
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					// 다 돌렸는데 0이 있으면 모두 익지 못하는 상황이므로 -1 반환
					if(box[z][x][y]==0) {
						return -1;
					}
					// box에 표시된 수 중에 제일 큰 수가 토마토가 다 익었을 경우
					// 모두 익은 마지막 날을 의미하므로 max를 이용한다
					max = Math.max(max, box[z][x][y]);
				}
			}
		}
		return max -1;
	}

}
