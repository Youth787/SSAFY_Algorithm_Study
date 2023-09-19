//혼자 풀기 시도...실패애애애애

//완전 제곱수 구하는 방법? i=1부터 돌면서 Math.sqrt(i) == i 되는 경우 있는지 찾아야 하나
//등차수열이 된다는건 두 공차의 방향이 서로 달라도 되는거니까...근데 범위랑 값을 못 정하겠다


package p1025_제곱수찾기;

import java.util.Scanner;

//[문제]n행 m열의 표 안의 숫자를 골라 만들 수 있는 정수 중 가장 큰 완전제곱수 
//[입력] n, m / 표 안의 숫자
//완전제곱수를 만들 수 없는 경우에는 -1
public class Main {
	
	static int n, m, tmp, ans;
	static int [][] nums;
		
	
	//p,q는 등차수열에서의 공차 저장. k는 지금 몇자리수가 만들어졌는지. 숫자 하나씩 붙여질 때는 기존 수*10+지금 수
	static void BFS(int n1, int m1, int p, int q, int k) {
		//기저 : 범위 밖으로 나갔을 떄
		if (n1<0 || n1>=n || m1<0 || m1 >=m) {
			if (ans == -1) {//main에서 ans가 -1라고 초기화해놨는데 
				return;  //아직도 -1이면 그대로 리턴
			}
			//여기까지 내려왔으면 완전 제곱수인지 판단.
			//완전제곱수 아니면 그냥 return
			//완전제곱수면 지금 ans 와 Math.max() 비교

		}
		
		tmp = tmp*10 + nums[n1][m1];//새로 만들어진 수

	}
	
	//최대한 멀리가야 만들 수 있는 가장 큰 완전제곱수 발견 가능
	//시작점은...
	
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int [n][m];
		for (int i = 0; i< n; i++) {
			char [] tmp = sc.nextLine().toCharArray();
			for (int j = 0; j< m; j++) {
				nums[i][j] = tmp[j] -'0';
			}
		}//입력
		
	}//main
}//class
