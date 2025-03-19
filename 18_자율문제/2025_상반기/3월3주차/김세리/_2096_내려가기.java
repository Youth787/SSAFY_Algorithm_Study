package _20250324;

import java.util.*;
import java.io.*;

public class _2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ansMax=0;
		int ansMin=Integer.MAX_VALUE;
		StringTokenizer st;
		int[][] dpMax = new int [N][3];
		int[][] dpMin = new int [N][3];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				dpMax[i][0] = a;
				dpMax[i][1] = b;
				dpMax[i][2] = c;
				ansMax = Math.max(a,Math.max(b,c));
				dpMin[i][0] = a;
				dpMin[i][1] = b;
				dpMin[i][2] = c;
				ansMin = Math.min(a,Math.min(b,c));
			}
			
			else {
				dpMax[i][0] = Math.max(dpMax[i-1][0],dpMax[i-1][1]) +a;
				dpMax[i][1] = Math.max(dpMax[i-1][0],Math.max(dpMax[i-1][1],dpMax[i-1][2])) +b;
				dpMax[i][2] = Math.max(dpMax[i-1][1],dpMax[i-1][2]) +c;
				
				ansMax = Math.max(dpMax[i][0],Math.max(dpMax[i][1],dpMax[i][2]));
				
				dpMin[i][0] = Math.min(dpMin[i-1][0],dpMin[i-1][1]) +a;
				dpMin[i][1] = Math.min(dpMin[i-1][0],Math.min(dpMin[i-1][1],dpMin[i-1][2])) +b;
				dpMin[i][2] = Math.min(dpMin[i-1][1],dpMin[i-1][2]) +c;
				
				ansMin = Math.min(dpMin[i][0],Math.min(dpMin[i][1],dpMin[i][2]));
				
				
			}
		}
		System.out.println(ansMax+" "+ansMin);
	}

}
