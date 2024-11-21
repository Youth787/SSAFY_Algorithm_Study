package _20241120;

import java.util.*;
import java.io.*;

public class _20207_달력 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] days = new int[366];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			for(int j=S;j<=E;j++) {
				days[j]++;
			}
		}
		int maxCnt=0;
		int start=0;
		int end=0;
		int ans=0;
		for(int i=1;i<=365;i++) {
			if(days[i]>0 && start==0) {
				start=i;
				maxCnt=days[i];
				end=i;
			} else if(days[i]>0 && start!=0) {
				if(maxCnt<days[i]) {
					maxCnt=days[i];
					end=i;
				} else {
					end=i;
				}
			} else if(days[i]==0 && start!=0) {
				ans += (end-start+1)*maxCnt;
				maxCnt=0; end=0; start=0;
			}
		}
		
		if(maxCnt!=0) {
			ans += (end-start+1)*maxCnt;
		}
		System.out.println(ans);
	}

}
