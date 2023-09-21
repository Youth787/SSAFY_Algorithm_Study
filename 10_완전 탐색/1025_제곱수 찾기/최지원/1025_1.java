package p1025_제곱수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//[문제]n행 m열의 표 안의 숫자를 골라 만들 수 있는 정수 중 가장 큰 완전제곱수 
//[입력] n, m / 표 안의 숫자
//완전제곱수를 만들 수 없는 경우에는 -1
public class Main {

	static int n, m;
	static int [][] nums;
	static int ans = -1;

	//지금 만든 수가 완전제곱수가 맞아?
	static boolean chk(int n1) {
		//제곱근을 구했다가 다시 제곱한 수가 원래 수일때
		if(Math.pow(Math.sqrt(n1),2) == n1) return true;
		return false;
	}

	//최대한 멀리가야 만들 수 있는 가장 큰 완전제곱수 발견 가능
	//시작점은...

	public static void main(String[] args) throws IOException {	
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		nums = new int[10][10]; //1부터지만 알아서 0부터 쓱
		for (int i = 0; i < n; i++) {
			String s1 = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s1.charAt(j)));
			}
		}//입력


		//시작점을 정하는 이중 for문 안에, 행/열 공차 정하는 이중 for문 있음 = 총 4중 for문
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; ++j) {
				for (int x = -n; x < n ; ++x) {//행의 등차는 맨 뒤에서 맨 앞으로 갈 수 있는 -n부터, 맨 앞에서 맨 뒤로 갈 수 있는 n-1까지
					for (int y = -m; y < m; y++) {//열의 등차는 마찬가지로 -m부터, m-1까지 (1부터 시작하니까...)
						if (x == 0 && y == 0) continue; // 둘다 움직이지 않으면 넘겨라
						int a = i; //공차를 반영해서 움직여야 하니까(변형을 해야 하니까 i,j값을 a,b에도 저장해줌
						int b = j;
						int temp = 0;
						while (a >= 0 && a < n && b >= 0 && b < m) {//범위 안이라면
							temp = temp*10 + nums[a][b]; // 그 전까지 구한 수는 10을 곱하고,다음 수를 일의자리에 더해서 수temp 만들어
							if (Math.abs(Math.sqrt(t) - (int)Math.sqrt(t)) < 1e-10) {
								ans = Math.max(ans, temp); // 완전 제곱수인지 판별되면 지금 최대값이랑 비교해봐
							}//숫자 다 완성하고 최종확인하는게 아니라, 중간에 계속 나오는 수를 확인해봐야 함
							a += x;//a는 공차x를 더한 값으로 바꿔서 while문을 돈다
							b += y;//b는 공차y를 더한 값으로 바꿔서 while문을 돈다
						}//q 공차 for문
					}//p 공차 for문
				}//j 시작점 for문
			}//i 시작점 for문

			System.out.println(ans);
		}//main
	}//class
