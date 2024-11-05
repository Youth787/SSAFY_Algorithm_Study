package _20241106;

import java.util.*;
import java.io.*;

public class _17144_미세먼지안녕 {
	static int R,C,T,airPurifierX=-1;
	static int[][] map, mapCopy;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(airPurifierX==-1) airPurifierX=i;
				}
			}
		}
		int sec=0;
		while(sec<T) {
			spread();
			runAirPurifier();
			sec++;
		}
		
		int ans=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) ans +=map[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	public static void spread() {
		mapCopy = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int dust=mapCopy[i][j]/5, spreadCnt=0;
				if(mapCopy[i][j]>0 && dust>0) {
					for(int d=0;d<4;d++) {
						int dr = i + dx[d];
						int dc = j + dy[d];
						
						if(dr>=0 && dc>=0 && dr<R && dc<C && mapCopy[dr][dc]!=-1) {
							spreadCnt++;
							map[dr][dc] += dust;
						}
					}
					map[i][j] = map[i][j]-dust*spreadCnt;
					
				}
			}
		}
		
	}
	
	static void runAirPurifier() {
		for(int i=airPurifierX-1;i>0;i--) {
				map[i][0]=map[i-1][0];
		}
		for(int j=0;j<C-1;j++) {
				map[0][j]=map[0][j+1];				
		}
		for(int i=0;i<airPurifierX;i++) {
				map[i][C-1]=map[i+1][C-1];
		}
		for(int j=C-1;j>1;j--) {
				map[airPurifierX][j]=map[airPurifierX][j-1];
		}
		map[airPurifierX][1]=0;
		
		for(int i=airPurifierX+2;i<R-1;i++) {
				map[i][0]=map[i+1][0];
		}
		for(int j=0;j<C-1;j++) {
				map[R-1][j]=map[R-1][j+1];
		}
		for(int i=R-1;i>airPurifierX+1;i--) {
				map[i][C-1]=map[i-1][C-1];
		}
		for(int j=C-1;j>1;j--) {
				map[airPurifierX+1][j] = map[airPurifierX+1][j-1];
		}
		map[airPurifierX+1][1]=0;
	}

}
