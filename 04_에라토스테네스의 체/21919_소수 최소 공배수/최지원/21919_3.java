//오답,,

//에라토스테네스 체 이용?
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
[문제] 길이가 n인 수열 a에서 소수를 골라 최소공배수를 구한다
[입력] n, a의 원소들
[출력] 소수들의 최소공배수, 소수 없으면 -1 출력
 * */
public class Main {

	public static void main(String[] args) {

		ArrayList<Boolean> primeList; //ArrayList로 Boolean타입을 다루는 'primeList'구현
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수열 길이
		int [] nums = new int[n]; //수열
		for (int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		int max = nums[n-1]; //수열의 최대값


		primeList = new ArrayList<Boolean>(max+1); //max+1 만한 사이즈로 ArrayList
		primeList.add(false); //primeList의 첫번째(0)는 소수 아님
		primeList.add(false); //primeList의 두번째(1)는 소수 아님
		//(1) 2부터 n까지 모든 정수를 primeList에 다 적는다
		for (int i=2; i<=max; i++){
			primeList.add(i, true);
		}

		int ans = 1; 

		for (int i = 2; (i*i) <=max; i++){
			if (primeList.get(i)){ //i를 primeList가 갖고 있으면
				for (int j = i*i; j <= max ; j += i){
					primeList.set(j, false); //i*i부터 n까지는 false(소수가 아니다. 지운다)
					//i*i 미만은 첫 번째 for문에서 이미 처리되었기 때문에 j의 시작값을 i*i로 설정
				}
			}
		}
		
		for (int i = 0; i<nums.length; i++) {
			if(primeList.get(nums[i])) ans= ans*nums[i];
		}
		if (ans == 1)
			ans = -1;

		System.out.println(ans);

	} //main

} //class
