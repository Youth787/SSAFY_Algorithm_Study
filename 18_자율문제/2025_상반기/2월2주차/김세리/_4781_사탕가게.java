package _20250217;

import java.util.*;
import java.io.*;

public class _4781_사탕가게 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			// 정수형으로 변환, 부동소수점이기 때문에 0.5를 더해서 확실하게 정수로 변환한다
			int m = (int) (Double.parseDouble(st.nextToken())*100+0.5);
			
			if(n==0 && m==0) break;
			
			// i원으로 얻을 수 있는 최대 칼로리
			int[] dp = new int[m+1];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int calories = Integer.parseInt(st.nextToken());
				int cost = (int) (Double.parseDouble(st.nextToken())*100+0.5);
				
				for(int j=cost;j<=m;j++) {
					dp[j] = Math.max(dp[j],dp[j-cost]+calories);
				}
			}
			sb.append(dp[m]).append("\n");
			
		}
		System.out.println(sb);
	}

}
