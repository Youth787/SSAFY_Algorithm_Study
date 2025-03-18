package _20250324;

import java.util.*;
import java.io.*;

public class _2665_미로만들기 {
	static int n,ans=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class node implements Comparable<node> {
		int x;
		int y;
		int cnt;
		public node(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(node o) {
			if(this.cnt==o.cnt) {
				return Integer.compare(this.y,o.y);
			}
			return Integer.compare(this.cnt,o.cnt);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}

		dijkstra(0,0,0);
		System.out.println(ans);
	}
	static void dijkstra(int x, int y, int cnt) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(x,y,cnt));
		visited[x][y]=true;
		
		while(!pq.isEmpty()) {
			node curr = pq.poll();
			
			if(curr.x==n-1 && curr.y==n-1) {
				ans = Math.min(ans,curr.cnt);
			}
			for(int d=0;d<4;d++) {
				int nr = curr.x+dx[d];
				int nc = curr.y+dy[d];
				if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]) {
					visited[nr][nc]=true;
					if(map[nr][nc]==0) {
//						System.out.println("nr: "+nr+" nc: "+nc+" cnt: "+cnt);
						pq.add(new node(nr,nc,curr.cnt+1));
					} else {
						pq.add(new node(nr,nc,curr.cnt));
					}
				}
			}
		}
	}

}
