package _20240711;

import java.util.*;
import java.io.*;

public class _19238_스타트택시 {
	
	static int N, M, fuel, rtexi, ctexi;
	static int[][] map; // 지도
	static int[][] dest; // 손님들의 도착지점 저장
	static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dest = new int[M+1][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				// map배열에 손님의 출발지를 함께 저장할 수 있도록 장애물 표시를 N으로 바꾼다
				// 0: 빈칸, N: 장애물
				map[i][j]= (temp == 0) ? 0 : N*N+1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		rtexi = Integer.parseInt(st.nextToken())-1;
		ctexi = Integer.parseInt(st.nextToken())-1;
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int rstart = Integer.parseInt(st.nextToken())-1;
			int cstart = Integer.parseInt(st.nextToken())-1;
			// map배열에 손님의 출발지를 기록한다
			map[rstart][cstart] = i;
			
			// dest 배열에 손님의 도착지 저장
			int rdes = Integer.parseInt(st.nextToken())-1;
			int cdes = Integer.parseInt(st.nextToken())-1;
			dest[i] = new int[] {rdes,cdes};
			
		}
		
		while(M>0) {
			
			// 현재 택시 지점에서 가장 가까운 손님에 대한 정보를 찾아서 가져온다
			int[] result = findNearestPassenger();
			
			// result[0]=rtexi, result[1]=ctexi, result[2]=dist
			// 적합한 후보군이 없거나 손님한테까지 갈 연료가 부족할 경우 break
			if(result[0]==-1 || fuel<result[2]) {
				fuel =-1;
				break;
			}
			// 택시가 손님의 출발지까지 이동 가능한 경우 이동하고, 정보를 업데이트한다
			fuel -= result[2];
			rtexi = result[0];
			ctexi = result[1];
			
			// 태운 손님 번호 저장
			int passengerId = map[rtexi][ctexi];
			// 손님 태웠으므로 출발지 표시 제거
			map[rtexi][ctexi]=0;
			
			// 도착지까지 거리 구하기
			int distanceToDest = bfs(rtexi, ctexi, dest[passengerId][0], dest[passengerId][1]);
			// 도착지까지 갈 연료가 부족하면 break
			if(distanceToDest == -1 || fuel < distanceToDest) {
				fuel = -1;
				break;
			}
			
			// 도착지까지 갈 수 있는 경우 이동하고, 정보를 업데이트한다
			fuel += distanceToDest;
			rtexi = dest[passengerId][0];
			ctexi = dest[passengerId][1];
			M--;
		}
		
		System.out.println(fuel);
		
	}//main
	
	static int[] findNearestPassenger() {
		
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {rtexi, ctexi, 0});
		
		visited[rtexi][ctexi]=true;
		
		// 조건을 만족하는 후보들을 후보군 배열에 넣는다
		List<int[]> candidates = new ArrayList<>();
		
		int minDistance = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			int dist = current[2];
			
			if(dist > minDistance) break;
			
			// map에서 0초과 N*N+1 미만인 경우는 손님들의 출발지인 경우이다
			// 따라서 여기 도달했을 때 후보군에 정보를 저장하고,
			// 최소 거리를 갱신해준다
			if(map[r][c]>0 && map[r][c]<N*N+1) {
				candidates.add(new int[] {r,c,dist});
				minDistance=dist;
			}
			
			for(int[]dir : directions) {
				int nr = r +dir[0];
				int nc = c +dir[1];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]!=N*N+1) {
					visited[nr][nc]=true;
					q.add(new int[] {nr,nc,dist+1});
				}
			}
		}
		// 후보가 없을땐 배열을 -1로 채워서 반환한다
		if(candidates.isEmpty()) return new int[] {-1,-1,-1};
		
		// 거리->행->열 이 작은 값이 반환되도록 sort를 정함
		candidates.sort((a, b) -> {
			
		    if (a[2] == b[2]) { // 거리 비교
		        if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // 행 비교
		        return Integer.compare(a[0], b[0]); // 열 비교
		    }
		    return Integer.compare(a[2], b[2]); // 거리 비교
		});
		
		// 우선순위 조건을 만족하는 후보의 정보를 result 배열로 반환한다
		return candidates.get(0);
	}
	
	static int bfs(int sr, int sc, int dr, int dc) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr, sc, 0});
		visited[sr][sc]=true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			int dist = current[2];
			
			// 도착지에 도착하면 거리를 반환한다
			if (r==dr && c==dc) return dist;
			
			for(int[] dir : directions) {
				int nr = r + dir[0];
				int nc = c + dir[1];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]!=N*N+1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr,nc, dist+1});
				}
			}
		}
		// 도착하지 못하면 -1을 반환한다
		return -1;
	}

}
