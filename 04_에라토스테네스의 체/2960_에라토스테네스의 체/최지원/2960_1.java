package p2960_에라토스테네스의체;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Boolean> primeList; //ArrayList로 Boolean타입을 다루는 'primeList'구현
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();


		primeList = new ArrayList<Boolean>(n+1); //n+1 만한 사이즈로 ArrayList
		primeList.add(false); //primeList의 첫번째(0)는 소수 아님
		primeList.add(false); //primeList의 두번째(1)는 소수 아님
		//(1) 2부터 n까지 모든 정수를 primeList에 다 적는다
		for (int i=2; i<=n; i++){
			primeList.add(i, true);
		}
		
		int cnt = 0; //몇 번째 지우는 수	
		int ans = 0; //정답 k번째 지우는 수
		
		out: while (true) {
			//(2) 2부터 n까지 정수중에
			for (int i = 2; i<=n; i++){
				if (primeList.get(i)){ //primeList에 i가 아직 지워지지 않았다면
					//(2) 아직 지우지 않은 수 중 가장 작은 수를 p라고 함(p: 소수)
					int p = i;
					//(3) p를 지우고, 아직 지우지 않은 p의 배수를 크기 순대로 지운다
					for (int q = 1; p*q <= n ; q++){
						primeList.set(p*q, false); //p의 배수를 지움
						cnt++; //몇번째 지운다
						if (cnt == k) { //
							ans = p*q;
							break out;
						}
					}
				}
			}
		}
		
		System.out.println(ans);

	}
}
