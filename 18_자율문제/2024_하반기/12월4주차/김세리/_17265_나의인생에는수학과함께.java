package _20241230;

import java.util.*;
import java.io.*;

public class _17265_나의인생에는수학과함께 {
	static int N;
	static int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	static char[][] map;
	static int[] dx = {0,1};
	static int[] dy = {1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		// map이 char 타입이므로 처음 값을 int로 바꿔서 넣어준다
		findRoute(0,0,Character.getNumericValue(map[0][0]));
		System.out.println(max+" "+min);
	}
	private static void findRoute(int x, int y, int currentSum) {
		
		if(x==N-1 && y==N-1) {
			min = Math.min(min, currentSum);
			max = Math.max(max, currentSum);
			return;
		}
		
		for(int d=0;d<2;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(Character.isDigit(map[nx][ny])) {
					int nextVal = Character.getNumericValue(map[nx][ny]);
					findRoute(nx,ny,calculate(currentSum, nextVal, map[x][y]));
				} else {
					findRoute(nx,ny,currentSum);
				}
				
			}

		}


	}
	
	private static int calculate(int a, int b, char operator) {
		if(operator=='*') return a*b;
		if(operator=='+') return a+b;
		if(operator=='-') return a-b;
		return a;
	}

}
