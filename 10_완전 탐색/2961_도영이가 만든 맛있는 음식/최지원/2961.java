
import java.util.Scanner;

//[문제] 재료 n 개와 각 재료의 s맛, b맛을 알 때, 하나 이상의 재료를 써서 신맛과 쓴맛의 차이가 가장 작은 경우의 최소값을 찾기
//요리의 신맛 = 재료 s맛의 곱. 쓴맛 = 재료 b맛의 합
public class Main {
	
	static int n, ans; 
	static int [][] info ; //재료 정보
	
	static void DFS (int idx, int sSum, int bSum) {
		//기저
		if (idx == n) {//끝까지 다 돌았다
			if (sSum == 1 && bSum==0) return;
			ans = Math.min(ans, Math.abs(sSum - bSum));//비교해서 최소값 찾아라
			return;
		}
		
		//재귀
		//이 재료 넣는다
		DFS(idx+1, sSum*info[idx][0], bSum+info[idx][1]);
		//이 재료 안넣는다
		DFS(idx+1, sSum, bSum);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		n = sc.nextInt();//재료 개수
		info = new int [n][2]; //[0]에는 s, [1]에는 b 값 저장
		for (int i = 0; i < n ; i++) {
			info[i][0] = sc.nextInt();//s
			info[i][1] = sc.nextInt();//b
		}
		ans = Integer.MAX_VALUE;
		
		DFS (0, 1, 0);//곱했을 때 0이면 안되니까 s합 값은 1로 초기화
		

		System.out.println(ans);
	}//main
}//class
