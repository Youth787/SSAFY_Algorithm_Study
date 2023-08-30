package p2960_에라토스테네스의체;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Boolean [] primeList = new Boolean[n+1]; //n+1 만한 사이즈로 Boolean타입의  배열 생성 (n+1인 이유는 0부터니까)
		//안에 있는 값들은 false로 초기화되어있음
		//(1) 2부터 n까지 모든 정수를 primeList에 다 적는다 = true로 바꾼다
		for (int i=2; i<=n; i++){
			primeList[i] = true;
		}
		
		int cnt = 0; //몇 번째 지우는지. (있다가 이미 지운수는 조건으로 걸러가면서 세자)	
		int ans = 0; //정답 k번째 지우는 수
		
		out: while (true) {
			//(2) 2부터 n까지 정수중에
			for (int i = 2; i<=n; i++){
				if (primeList[i]){ //primeList에 i가 true 상태라면
					//(2) 아직 지우지 않은 수 중 가장 작은 수를 p라고 함(p: 소수다)
					int p = i;
					primeList[i] = false; //(3-1) p를 지우고
					cnt++;
					if (cnt == k) { //만약 k번째 지웠으면
						ans = p; //ans에 답을 저장하고
						break out; //나간다
					}
					//(3-2) 아직 지우지 않은 p의 배수를 크기 순대로 지운다
					for (int j = i*i; j <= n ; j+=i){
						//여기서 초기값을 i*i라고 하는 이유는, i*i이하의 값은 이미 이전 작업에서 처리되었기 때문
						if (primeList[j]){ //primeList에 j가 true 상태라면
							primeList[j] = false; //j를 지우고
							cnt++;
							if (cnt == k) { //만약 k번째 지웠으면
								ans = j; //ans에 답을 저장하고
								break out; //나간다
							}
						}
						
						
					}
				}
			}
		}
		
		System.out.println(ans);

	}
}
