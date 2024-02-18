package p1244_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 성별과 받은 숫자에 따라 스위치 조작.
 * 남) 스위치 번호가 자기가 받은 수의 배수 => 바꾼다.
 * 여) 자기가 받은 수의 스위치를 중심으로 좌우대칭 만들어서 그 구간의 스위치를 모두 바꿈
 * */
public class Main {
	static int[] swc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫 줄에는 스위치 개수
		int n = Integer.parseInt(br.readLine()); //스위치 개수
		swc = new int[n+1]; //스위치 상태(1번부터니까)
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			swc[i] = Integer.parseInt(st.nextToken());
		} //스위치 상태 입력
		int m = Integer.parseInt(br.readLine()); //학생 수
		int[][] info = new int[m][2]; //성별, 받은 수
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); //성별 1 vs. 2
			info[i][1] = Integer.parseInt(st.nextToken()); //받은 수
		} //받은 수 입력
		
		//info 순서대로 처리
		for (int i = 0; i < m; i++) {
			if (info[i][0] == 1) {
				//남자는 본인수 배수
				for (int j = 1; j <= n; j++) {
					if (j % info[i][1] == 0) {
						change(j);
					}
				}
			} else {
				//여자는 대칭되는지 확인
				change(info[i][1]);
				int p = 1;
				while (true) {
					if (info[i][1]-p >= 1 && info[i][1]+p <= n && (swc[info[i][1]+p] == swc[info[i][1]-p] )) {
						//범위 내이고, 같으면
						change(info[i][1]-p);
						change(info[i][1]+p);
						p++;
					} else {
						break;
					}
				}
			} //성별에 따라 처리
		} //모든 학생 처리 끝
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i>20 && i%20 == 1) {
				sb.append('\n');
			}
			sb.append(swc[i]).append(' ');
		}
		
		System.out.println(sb);
		
		//출력은 한 줄에 20개씩 출력
	} //main
	
	public static void change(int num) {
		if (swc[num] == 1) {
			swc[num] = 0;
		} else {
			swc[num] = 1;
		}
	}
} //class

/*
				for (int j = info[i][1], k = 1; j <= n; j=j*k, k++) {
					change(swc[j]);
				}
남학생일때 이런식으로 하면 왜 오답일까
챗 친구의 답변은
이 반복문은 j를 info[i][1]로 시작하여, 각 반복마다 j를 k로 곱하고, k를 증가시킵니다. 
그러나 이 코드는 info[i][1]의 배수를 찾는 목적으로는 적합하지 않습니다. 
왜냐하면 j=j*k 부분이 기대하는 방식으로 info[i][1]의 배수를 증가시키지 않기 때문입니다. 
k의 증가에 따라 j의 값이 예측할 수 없는 방식으로 증가하게 되어, 원하는 배수를 찾는 것이 아니라 복잡한 수열을 생성하게 됩니다.

*/
