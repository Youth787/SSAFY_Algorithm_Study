package _20250203;

import java.util.*;
import java.io.*;

public class _1941_소문난칠공주 {
	static boolean[][] visited = new boolean[5][5];
	static char[][] map = new char[5][5];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans=0;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		List<int[]> candidates = new ArrayList<>();
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				candidates.add(new int[] {i,j});
			}
		}
		
		combination(candidates, new ArrayList<>(), 0, 0);
		
		System.out.println(ans);
	}
	static void combination(List<int[]> candidates, List<int[]> selected, int start, int depth) {
		if(depth==7) {
			if(isValid(selected)) {
				selected.sort(Comparator.comparingInt(a->a[0]*5+a[1]));
				StringBuilder sb = new StringBuilder();
				for(int[] pos : selected) {
					sb.append(pos[0]).append(pos[1]);
				}
				if(!set.contains(sb.toString())) {
					set.add(sb.toString());
					ans++;
				}
			}
		}
		
		for(int i=start;i<candidates.size();i++) {
			selected.add(candidates.get(i));
			combination(candidates, selected, i+1, depth+1);
			selected.remove(selected.size()-1);
		}
		
	}
	
	static boolean isValid(List<int[]> selected) {
		boolean[][] tempVisited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		int scount=0;
		
		q.add(selected.get(0));
		tempVisited[selected.get(0)[0]][selected.get(0)[1]]=true;
		int count =1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(map[curr[0]][curr[1]]=='S') scount++;
			
			for(int d=0;d<4;d++) {
				int nx = curr[0]+dx[d];
				int ny = curr[1]+dy[d];
				for(int[] pos : selected) {
					if(pos[0] == nx && pos[1]==ny && !tempVisited[nx][ny]) {
						tempVisited[nx][ny]=true;
						q.add(new int[] {nx,ny});
						count++;
					}
				}
			}
		}
		
		return count==7 && scount>=4;
	}

}
