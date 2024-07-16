package _20240716;

import java.util.*;
import java.io.*;

public class _19951_태상이의훈련소생활 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] height = new int[N+1];
		int[] diff = new int[N+2];

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// k를 더해줄 시작점 기록
			diff[a] +=k;
			// k를 빼줄 끝점 기록
			// a부터 b까지는 k를 더하고, 그 다음 칸에서는 k를 더하면 안되니까 더했다가 빼주기 위함
			if(b+1<=N) {
				diff[b+1]-=k;
			}

		}
		int sum=diff[0];
		for(int i=1;i<=N;i++) {
			// i 시점까지의 diff값을 더해준게 sum
			sum += diff[i];
			// 그리고 그 sum 값을 해당 height[i]에 반영
			height[i] += sum;
			// if(height[i]>10000) height[i]=10000;
			// if(height[i]<-10000) height[i]=-10000;
		}


		for(int i=1;i<=N;i++) {
			System.out.print(height[i]+" ");
		}
	}//main

}
