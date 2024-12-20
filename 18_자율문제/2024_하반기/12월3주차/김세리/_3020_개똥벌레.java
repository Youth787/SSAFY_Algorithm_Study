package _20241223;

import java.util.*;
import java.io.*;

public class _3020_개똥벌레 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		// 석순
		int[] bottom = new int[H+1];
		// 종유석
		int[] top = new int[H+1];
		
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(i%2==0) {
				bottom[tmp]++;
			} else {
				top[tmp]++;
			}
		}
		
		// 누적합 계산
		// 결국 높이가 3인 석순이 있다면 높이1, 2에도 더해줘야 하는데,
		// 누적합을 이용해서 더해주는 것.
		// bottom[3] 값을 bottom[2]에다가 더하는 식으로.
		for(int i=H-1;i>0;i--) {
			bottom[i] += bottom[i+1];
			top[i] += top[i+1];
		}
		
		int min=Integer.MAX_VALUE;
		int cnt=0;
		for(int i=1;i<=H;i++) {
			// top은 위에서부터 계산되어야 하므로 H-i+1을 하면 실제론 i위치의 값이 나온다.
			int totalObstacles = bottom[i] + top[H-i+1];
			if(totalObstacles<min) {
				min = totalObstacles;
				cnt=1;
			} else if (totalObstacles==min) {
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(count));
		System.out.println(min+" "+cnt);
	}

}
