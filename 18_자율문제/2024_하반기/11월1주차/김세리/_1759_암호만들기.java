package _20241106;

import java.util.*;
import java.io.*;

public class _1759_암호만들기 {
	static char[] crr, ans;
	static int L, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		crr = br.readLine().replace(" ", "").toCharArray();
		ans = new char[L];
		
		Arrays.sort(crr);
		findPW(0,0);
		
	}
	// x: 시작할 위치, cnt: 현재까지 선택한 문자 개수
	public static void findPW(int x, int cnt) {
		if (cnt==L) {
			if(isValid(ans)) {
				// char배열일 때만 이렇게 출력해도 알아서 String문자로 이어서 나온다
				System.out.println(ans);
			}
			return;
		}
		for(int i=x;i<C;i++) {
			ans[cnt]=crr[i];
			// i+1: 이미 선택한 문자 이전으로 돌아가지 않음
			// cnt+1: 현재 선택한 위치 다음에 오는 문자를 선택
			// 이렇게 하면 중복으로 선택이 되지 않으면서 모든 조합 생성 가능하다
			findPW(i+1,cnt+1);
		}
	}
	
	public static boolean isValid(char[] ans) {
		int moo=0, jaa=0;
		for(int i=0;i<L;i++) {
			if(ans[i]=='a'||ans[i]=='e'||ans[i]=='i'||ans[i]=='o'||ans[i]=='u') moo++;
			else jaa++;
		}
		if(moo>0 && jaa>1) return true;
		return false;
	}

}
