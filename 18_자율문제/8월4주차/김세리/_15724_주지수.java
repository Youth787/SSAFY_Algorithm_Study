package _20240827;

import java.util.*;
import java.io.*;

public class _15724_주지수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				 int tmp = Integer.parseInt(st.nextToken());
				 if(j==0) map[i][j] = tmp;
				 else map[i][j] = map[i][j-1]+tmp;
			}
		}
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int tc=0;tc<K;tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			int sum = 0;
			if(x1==0 && y1==0) {
				for(int i=0;i<=x2;i++) {
					sum += map[i][y2];
				}
			} else if(x1==0) {
				for(int i=0;i<=x2;i++) {
					sum += map[i][y2];
					sum -= map[i][y1-1];
				}
			} else if(y1==0) {
				for(int i=x1;i<=x2;i++) {
					sum += map[i][y2];
				}
			} else {
				for(int i=x1;i<=x2;i++) {
					sum += map[i][y2];
					sum -= map[i][y1-1];
				}
			}
			System.out.println(sum);
		}
	}

}
