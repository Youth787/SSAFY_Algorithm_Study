import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
[문제] 길이가 n인 수열 a에서 소수를 골라 최소공배수를 구한다
[입력] n, a의 원소들
[출력] 소수들의 최소공배수, 소수 없으면 -1 출력
* */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수열 길이
		int [] nums = new int[n]; //수열
		for (int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		
        
		ArrayList <Integer> sel = new ArrayList<>(); //수열 중 소수만 적을래
		
		for (int i=0;i<n;i++) {
			if (isPrime(nums[i])==1) { //소수면
				sel.add(nums[i]); //sel에 추가한다
			}
		} 
		
		//중복 제거
		HashSet<Integer> hashSet = new HashSet<>();
        for(Integer num : sel){
            hashSet.add(num);
        }
		
		int ans = 1; //곱을 구해야하니까 1로 초기화
		
		for (int i = 0; i<sel.size(); i++) {
	        for(Integer num : sel){
	            ans*=num;
	        }
		}
		if (ans == 1)
			ans = -1;

		System.out.println(ans);

	} //main
	
	public static int isPrime(int k) {
		for (int i = 2; i<=(int)Math.sqrt(k); i++) {
	      if (k % i == 0) {
	          return 0;
	      }
		}
		return 1;
	}

} //class
