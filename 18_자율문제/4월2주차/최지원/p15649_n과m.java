// n이랑 m을 안들고 다니게 static으로 변수를 빼버렸더니 메모리 증가(25,000kb->54,000kb), 시간도 엄청 증가(330ms->2000ms)
// n과 m을 들고다니면서 depth가 m이 되었을 때 그때그때 출력하게 했더니 시간초과
// StringBuilder를 사용해서 결과를 모으고 한 번에 출력했더니 시간 감소(212ms)

package p15649_n과m;

import java.util.Scanner;

/*
 * 1부터 n까지 자연수 중 "중복 없이" m개를 고른 "수열"을 모두 구하기
 * 중복되는 수열을 여러번 출력x
 * */
public class Main {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[m];
		visited = new boolean[n];
		
		number(n,m,0);
		System.out.println(sb);
	}
	
	static void number(int n, int m, int depth) {
		if (depth == m) {
			for ( int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				number(n, m, depth+1);
				visited[i] = false;
			}
		}
	}
	
//처음 잘못 풀었을 때...이건 조합임
//	static int n;
//	static int m;
//	static int[] arr;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		arr = new int[m];
//		
//		number(0,0);
//	} //main
//	
//	static void number(int idx, int sIdx) {
//		if (sIdx == m) {
//			for (int num : arr) {
//				System.out.print(num+" ");
//			}
//			System.out.println();
//			return;
//		}
//		if (idx == n) {
//			return;
//		}
//		
//		arr[sIdx] = idx + 1;
//		number(idx+1,sIdx+1);
//		number(idx+1,sIdx);
//	}

} //class

