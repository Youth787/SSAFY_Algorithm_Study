package _20250224;

import java.util.*;
import java.io.*;

public class _7795_먹을것인가먹힐것인가 {
	static int N,M;
	static int[] A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int ans=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			Arrays.sort(B);
			for(int i=0;i<N;i++) {
				ans += binarySearch(A[i]);
			}
			System.out.println(ans);
		}
	}
	static int binarySearch(int target) {
		int left=0;
		int right=M-1;
		int cnt=0;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(B[mid]<target) {
				cnt=mid+1;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return cnt;
	}

}
