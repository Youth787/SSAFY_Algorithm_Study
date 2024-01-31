import java.util.*;
import java.io.*;

//1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱 
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD
public class Solution1217 {
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for (int t=1; t<=tc; t++) {
			int tcnum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int ans = pow(1,0);
			System.out.printf("#%d %d\n",t,ans);
		}
	}
	static int pow(int num, int cnt) {
		if (cnt==m) return num;
		return pow(num*n,cnt+1);
	}
}
