//시간초과

import java.util.ArrayList;
import java.util.Scanner;

/*
[문제] 하나 이상의 연속된 소수의 합으로 n을 나타낼 수 있는 경우의수
* 
* */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList <Integer> sel = new ArrayList<>(); //소수만 적을래
		
		for (int i=0;i<=n;i++) {
			if (isPrime(i)==1) { //소수면
				sel.add(i); //sel에 추가한다
			}
		} 
		
	    int [] nums = new int [sel.size()];
	    for (int i = 0; i < nums.length; i++) {
	    	for(Integer num : sel){
	            nums [i] =num;
	        }
	    }

	    int cnt = 0;

	    //합 만들어보기
	    for (int i=0; i <n; i++) { //합 시작점
	    	int sum = nums[i];
	    	if (sum==n) {
	    		cnt++;
//	    		System.out.println(sum+"너 맞네");
	    		break;
	    	} else {
	    		for (int j= i+1;j<nums.length;j++) {
//	    			System.out.println(sum+"에"+real[j]+"를 더해볼게");
	    			sum += nums[j];
	    			if (sum > n) {
//	    				System.out.println(sum+"넌 아니다");
	    				break;
	    			} else if (sum == n) {
//	    				System.out.println(sum+"너 맞네");
	    				cnt++;
	    				break;
	    			}
	    		}
	    	}
	    }
	    System.out.println(cnt);

	    
	}
	
	public static int isPrime(int k) {
		for (int i = 2; i<=(int)Math.sqrt(k); i++) {
	      if (k % i == 0) {
	          return 0;
	      }
		}
		return 1;
	} //isPrime

}
