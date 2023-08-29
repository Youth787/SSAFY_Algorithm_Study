//*오답*
//testcase만 맞음
//그냥 요렇게 풀고 싶었다,,,그런거


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
[문제] 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		
		
		ArrayList<Boolean> primeList; //ArrayList로 Boolean타입을 다루는 'primeList'구현

	    if (n <= 1) return; //n이 1보다 작거나 같아지면 종료하겠다

	    primeList = new ArrayList<Boolean>(n+1); //n+1 만한 사이즈로 ArrayList
	    primeList.add(false); //primeList의 첫번째(0)는 소수 아님
	    primeList.add(false); //primeList의 두번째(1)는 소수 아님

	    //(1) 2부터 n까지의 수를 primeList에 다 넣는다
	    for (int i=2; i<=n; i++){
	      primeList.add(i, true);
	    }

	    //(2) 2부터 i*i<=n일때까지 각각의 배수들을 지워간다
	    for (int i = 2; (i*i) <=n; i++){
	      if (primeList.get(i)){ //i를 primeList가 갖고 있으면
	        for (int j = i*i; j <= n ; j += i){
	          primeList.set(j, false); //i*i부터 n까지는 false(소수가 아니다. 지운다)
	          //i*i 미만은 첫 번째 for문에서 이미 처리되었기 때문에 j의 시작값을 i*i로 설정
	        }
	      }
	    }
	    
	    //소수들만 따로 저장
	    int [] nums = new int [primeList.size()];
	    
	    int idx = 0;
	    for (int i =0; i<primeList.size();i++) { //사이즈만큼 돌면서
			if(primeList.get(i)) { //값이 있으면
				nums[idx++]=i;
			}		
		}
	    
	    int IDX = 0;
	    for (int i = 0; i<nums.length;i++) {
	    	if (nums[i]==0) {
	    		IDX =i;
	    		break;
	    	}
	    }
	    
	    int [] real = new int[IDX];
	    for (int i=0; i<IDX; i++) {
	    	real[i] = nums[i];
	    }

//	    System.out.println(Arrays.toString(real));

	    int cnt = 0;

	    //합 만들어보기
	    for (int i=0; i <=real.length-1; i++) { //합 시작점
	    	int sum = real[i];
	    	if (sum==n) {
	    		cnt++;
//	    		System.out.println(sum+"너 맞네");
	    		break;
	    	} else {
	    		for (int j= i+1;j<real.length;j++) {
//	    			System.out.println(sum+"에"+real[j]+"를 더해볼게");
	    			sum += real[j];
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

}
