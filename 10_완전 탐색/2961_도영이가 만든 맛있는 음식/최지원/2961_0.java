package p2961_도영이가만든맛있는음식;
//아직 푸는 중

import java.util.Scanner;

//재료 n개가 있고 각 재료의 신맛 s와 쓴맛b를 알고 있을 때 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램
//음식의 신맛 = 재료 신맛의 곱, 쓴맛은 합
//요리의 신맛과 쓴맛의 차이를 작게 만드려고 함
//재료 적어도 1개는 사용해야 함

//[입력] 재료 개수 n(1~10)개, n개 줄에 신맛, 쓴맛
//[출력] 신맛과 쓴맛의 차이가 가장 작은 요리의 차이

public class Main {
	
	public static int ans, n, cnt;
	public static int [][] info;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //재료 개수
		//문제 풀이 방식 : 공집합을 제외한 모든 부분집합의 경우에서 신맛과 쓴맛을 계산하고, 현재 최소값과 비교하는 방식
		//재료 정보 입력 신맛, 쓴맛
		info = new int [n][2];
		for (int i=0; i<n; i++) {
			info[i][0] = sc.nextInt(); //그 재료의 신맛
			info[i][1] = sc.nextInt(); //그 재료의 쓴맛
		}//정보 입력
		
		ans = Integer.MAX_VALUE; //최소값을 찾는 문제이기 때문에 int형의 최대값으로 초기화
		cnt = 0;
		//모든 부분집합을 도는 방법
		comb(0,0,0);
		System.out.println(ans);
		
	}//main
	
	//재귀함수
	//인자로 min값
	public static void comb(int idx, int sRes, int bRes) {
		//기저 파트
		if (idx == n) {//재료를 끝까지 다 돌았다면
			if (sRes ==0 && bRes ==0) return; //재료 아무것도 안들어간 음식은 없으
			ans = Math.min(ans, Math.abs(sRes-bRes)); //지금까지의 결과와 현재 최소값의 비교
			return;
		}
		//재귀 파트
		//재료쓸까
		cnt++;
		if (cnt >=1 && sRes ==0) sRes = 1;
		comb(idx+1,sRes*info[idx][0],bRes+info[idx][1]);//sRes에는 신 맛 값을 곱하고, bRes에는 쓴 맛 값을 더하여 다음 재귀로 넘겨줌
		//재료 안쓸까
		comb(idx+1,sRes,bRes);//값이 그대로
	}//comb
}//class
