// package p9082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2*n 배열에 숨겨진 지뢰를 찾는다
 * 지뢰 확실히 있는 곳은 *, 숨겨진 블록을 #로 표시
 * *까지 포함하여 주어진 배열에 있는 모든 지뢰의 개수 출력(지뢰는 둘째 줄에만 있다)
 * testcase는 1~10개, n은 1~100 사이, 첫 줄은 항상 숫자(공백x)
 * 
 * 2*n 사이즈이고 지뢰가 윗줄에 없으니 윗줄에 나올 수 있는 수는 0~3.
 * 밑줄에서 *이 있다면 이걸 우선순위로 확인해야함
 * 지뢰 있나 확인해야 하는 곳은 -1(왼쪽),0(본인),1(오른쪽) 
 * 
 * */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());//tc 개수
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());//n	
			int cnt = 0;//tc에서의 지뢰 수
			int[] num = new int [n];//숫자줄
			String tmp = br.readLine();
			for (int i = 0; i < n; i++) {
                num[i] = tmp.charAt(i)-'0';
            }
			char[] cha = br.readLine().toCharArray();//기호줄
			
			for (int i = 0; i < n; i++) {
				if (cha[i] == '*') {
					cnt++;
					continue;
				}
				if (i == 0) {
					if (num[0]!= 0 && num[1] != 0) {
						num[0]--;
						num[1]--;
						cnt++;
					}
				} else if (i == (n-1)) {
					if (num[i] != 0 && num[i-1] != 0) {
						num[i-1]--;
						num[i]--;
						cnt++;
					}
				} else {
					if (num[i-1] != 0 && num[i] != 0 && num[i+1] != 0) {
						num[i-1]--;
						num[i]--;
						num[i+1]--;
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
		
	}//main
}//class
