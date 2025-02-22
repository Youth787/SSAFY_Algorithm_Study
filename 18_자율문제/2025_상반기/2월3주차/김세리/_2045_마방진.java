package _20250224;

import java.util.*;
import java.io.*;

public class _2045_마방진 {
	static int[][] map;
	static Queue<int[]> zeroPositions = new LinkedList<>();
	static int targetSum=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[3][3];
				
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					zeroPositions.add(new int[] {i,j});
				}
			}
		}
		findTargetSum();
		
		while(!zeroPositions.isEmpty()) {
			fillZero();
		}
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	public static void findTargetSum() {
		boolean found=false;
		
		for(int i=0;i<3;i++) {
			if(map[i][0]!=0 && map[i][1]!=0 && map[i][2]!=0) {
				targetSum = map[i][0] + map[i][1] + map[i][2];
				found=true;
				return;
			}
			if(map[0][i]!=0 && map[1][i]!=0 && map[2][i]!=0) {
				targetSum = map[0][i] + map[1][i] + map[2][i];
				found=true;
				return;
			}
		}
		if(map[0][0]!=0 && map[1][1]!=0 && map[2][2]!=0) {
			targetSum = map[0][0] + map[1][1] + map[2][2];
			found=true;
			return;
		}
		if(map[0][2]!=0 && map[1][1]!=0 && map[2][0]!=0) {
			targetSum = map[0][2] + map[1][1] + map[2][0];
			found=true;
			return;
		}
		// 위 경우에서 targetSum을 구할 수 없는 경우는 결국 대각선 하나가 비어있을 때이다
		// 대각선 하나가 비어있는 경우, 마방진의 성질을 이용하면
		// 마방진에 주어진 나머지 수를 전부 더한 값이 targetSum*2 임을 알 수 있다
		// 그래서 전체 수를 더하고 /2를 해주면 targetSum을 구할 수 있다
		if(!found) {
			int tmp = 0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					tmp += map[i][j];
				}
			}
			targetSum = tmp/2;
			found=true;
			return;
		}
	}
	
	public static void fillZero() {
		int[] curr = zeroPositions.poll();
		int row = curr[0];
		int col = curr[1];
		
		int sum=0, zeroCount=0;
		// 행 검사
		for(int j=0;j<3;j++) {
			if(map[row][j]==0) zeroCount++;
			sum += map[row][j];
		}
		if(zeroCount==1) {
			map[row][col] = targetSum-sum;
			return;
		}
		sum=0; zeroCount=0;
		// 열 검사
		for(int i=0;i<3;i++) {
			if(map[i][col]==0) zeroCount++;
			sum += map[i][col];
		}
		if(zeroCount==1) {
			map[row][col] = targetSum-sum;
			return;
		}
		sum=0; zeroCount=0;
		// 대각선 검사
		if(row==col) {
			for(int i=0;i<3;i++) {
				if(map[i][i]==0) zeroCount++;
				sum += map[i][i];
			}
			if(zeroCount==1) {
				map[row][col] = targetSum-sum;
				return;
			}
		}
		sum=0; zeroCount=0;
		if(row+col==2) {
			for(int i=0;i<3;i++) {
				if(map[i][2-i]==0) zeroCount++;
				sum += map[i][2-i];
			}
			if(zeroCount==1) {
				map[row][col] = targetSum-sum;
				return;
			}
		}
		
		zeroPositions.add(new int[] {row,col});
	}

}
