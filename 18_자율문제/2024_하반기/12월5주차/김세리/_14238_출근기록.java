package _20250106;

import java.util.*;
import java.io.*;

public class _14238_출근기록 {
	static int[] count = new int[3]; // A,B,C 개수 count
	static char[] result;
	static boolean found=false;
	static boolean[][][][][][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for(char c : input.toCharArray()) {
			count[c-'A']++;
		}
		
		result = new char[input.length()];
		// A개수,B개수,C개수,prev1,prev2,depth 저장
		memo = new boolean[count[0]+1][count[1]+1][count[2]+1][4][4][result.length+1];
		
		// 그냥 기본값으로 0값을 넣은것. 처음에 답에 영향주지 않는 다른것 넣어도 상관없음.
		// 어차피 depth0 이라서 답 후보에 안들어감.
		dfs(0,'\0','\0');
		
		if(!found) {
			System.out.println(-1);
		}
	}
	static void dfs(int depth, char prev1, char prev2) {
		if(depth==result.length) {
			found=true;
			System.out.println(new String(result));
			return;
		}
		
		int a=count[0], b=count[1], c=count[2];
		int p1 = prev1 =='A' ? 0:(prev1=='B' ? 1:(prev1=='C' ? 2:3));
		int p2 = prev2 =='A' ? 0:(prev2=='B' ? 1:(prev2=='C' ? 2:3));
		if(memo[a][b][c][p1][p2][depth]) return;
		
		memo[a][b][c][p1][p2][depth]=true;
		
		for(int i=0;i<3;i++) {
			char current = (char)('A'+i);
			if(count[i]==0) continue;
			if(current=='B' && prev1=='B') continue;
			if(current=='C' && (prev1=='C' || prev2=='C')) continue;
			
			count[i]--;
			result[depth] = current;
			
			dfs(depth+1,current,prev1);
			
			if(found) return;
			// 백트래킹
			count[i]++;
		}
	}

}
