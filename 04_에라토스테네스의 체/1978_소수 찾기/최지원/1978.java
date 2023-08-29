
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
[문제] 주어진 수 n개 중 소수가 몇개인지 출력
[입력] (100이하)n, (1000이하)n개의 수
 * */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //주어진 숫자 개수
		
		int [] nums = new int[n];
		
		for (int i = 0; i< n ; i++) {
			nums[i] = sc.nextInt();
		} //입력 완
		
		//정렬해서 주어진 n개의 수 중 가장 큰 수를 찾고 max에 저장
		Arrays.sort(nums);
		int max = nums[n-1];
		
		//max까지의 수 중 소수인 수를 저장
		Boolean [] primeList = new Boolean[max+1]; // Boolean타입 'primeList'구현
		
	    //(1) 2부터 n까지의 수를 primeList에 다 넣는다
	    for (int i=2; i<=max; i++){
	      primeList[i] = true;
	    }

	    //(2) 2부터 i*i<=n일때까지 각각의 배수들을 지워간다
	    for (int i = 2; (i*i) <=max; i++){
	      if (primeList[i]){ //i를 primeList가 갖고 있으면
	        for (int j = i*i; j <= max ; j += i){
	          primeList[j]= false; //i*i부터 n까지는 false(소수가 아니다. 지운다)
	          //i*i 미만은 첫 번째 for문에서 이미 처리되었기 때문에 j의 시작값을 i*i로 설정
	        }
	      }
	    }
	    
	    //주어진 n개의 수와 비교
	    int ans = 0;
		
	    for (int j = 2; j<=max; j++) {
	    	if (primeList[j]) { //소수일때만
	    		for (int i=0; i<n; i++) {
	    			if (nums[i]==j) {
	    				ans++;
	    			}
	    		}
	    	}
	    }
	    
	    System.out.println(ans);

	} //main

} //class
