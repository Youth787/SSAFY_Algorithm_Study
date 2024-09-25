package _20240711;

import java.util.*;
import java.io.*;

public class _17779_게리맨더링2 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndCalculate();
		
	}//main

	static void divideAndCalculate() {
		int minDifference = Integer.MAX_VALUE;

		for (int x=0;x<N;x++) {
			for (int y=0;y<N;y++) {
				for (int d1=1;d1<N;d1++) {
					for (int d2=1;d2<N;d2++) {
						if (x+d1+d2<N && y-d1>=0 && y+d2<N) {
							// 선거구 나누기 및 인구 계산을하고, 가장 작은 차이값을 구한다
							minDifference = Math.min(minDifference, calculatePopulationDifference(x, y, d1, d2));
						}
					}
				}
			}
		}

		System.out.println(minDifference);
	}

	static int calculatePopulationDifference(int x, int y, int d1, int d2) {
		
		// 선거 구역을 입력할 배열 area를 만든다
		int[][] area = new int[N][N];

		// 경계선 설정
		for (int i=0;i<=d1;i++) {
			area[x+i][y-i] = 5;
			area[x+d2+i][y+d2-i] = 5;
		}
		for (int i=0;i<=d2;i++) {
			area[x+i][y+i] = 5;
			area[x+d1+i][y-d1+i] = 5;
		}

		// 경계선 안쪽을 5번 선거구로 채우기
		for (int i=x+1;i<x+d1+d2;i++) {
			boolean flag = false;
			for (int j=0;j<N;j++) {
				if (area[i][j] == 5) flag = !flag;
				if (flag) area[i][j] = 5;
			}
		}

		// 나머지 선거구 채우기
		int[] populationSum = new int[6];
		
		// 각 선거구가 경계가 아닐 때 해당되는 선거구에 값을 더한다
		for (int i=0;i<x+d1;i++) {
			for (int j=0;j<=y;j++) {
				if (area[i][j] != 5) populationSum[1] += map[i][j];
			}
		}
		for (int i=0;i<=x+d2;i++) {
			for (int j=y+1;j<N;j++) {
				if (area[i][j] != 5) populationSum[2] += map[i][j];
			}
		}
		for (int i=x+d1;i<N;i++) {
			for (int j=0;j<y-d1+d2;j++) {
				if (area[i][j] != 5) populationSum[3] += map[i][j];
			}
		}
		for (int i=x+d2+1;i<N;i++) {
			for (int j=y-d1+d2;j<N;j++) {
				if (area[i][j] != 5) populationSum[4] += map[i][j];
			}
		}

		// 5번 선거구 인구수 계산
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (area[i][j] == 5) populationSum[5] += map[i][j];
			}
		}
		
		// populationSum 배열을 스트림으로 바꾸고, 최대값을 찾아 실제 값으로 변환한다
		// max 메서드는 OptionalInt 타입을 반환하기 때문에 getAsInt를 사용해야 한다
		int maxPopulation = Arrays.stream(populationSum).max().getAsInt();
		
		// 선거구에 인구수가 없는 경우를 제외하기 위해 스트림에서 각 요소를 필터링한다
		// p -> p >0 은 인구수가 0보다 큰 값만 남긴다
		int minPopulation = Arrays.stream(populationSum).filter(p -> p > 0).min().getAsInt();
		
		// 이 두개의 차이를 계산하여 차이값을 반환한다
		return maxPopulation - minPopulation;
	}

}
