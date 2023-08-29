import java.util.Arrays;
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
		int [] arr = new int[n]; //수열
		for (int i = 0; i <n; i++) {
			arr[i] = sc.nextInt();
		} //수열 입력
		
		Arrays.sort(arr);
		
		//혹시모를 중복 제거(중복된 값있으면0으로 만들기)
		for (int i = 0; i<n-1;i++) {
			for (int j=i+1;j<n;j++) {
				if (arr[i]==arr[j]) {
					arr[j]=0;
				}
			}
		}
		
	    int ans = 1; //곱 해야 하니까 1로 초기화
		
	    //수열 arr 중 소수 찾기
	    for (int i =0; i <n; i++) {
	    	if (arr[i]!=0) { //소수 아니라서 0으로 바꾼 친구들 제외
	    		int cnt = 0; //약수 개수 cnt
	    		for (int j =1;j<=arr[i];j++) { //1과 자기자신 제외하고 약수가 있는지 확인 for문
	    			if (arr[i]%j==0) { //1과 자기자신 말고 약수가있나
	    				cnt++;
	    				if (cnt>2) {
	    					break;
	    				}
	    			}
	    			if(j==arr[i] && cnt ==2) { //끝까지 왔는데 cnt2개였으면 소수
		    			ans *=arr[i]; //소수들의 최소공배수는 그냥 그 소수들 곱	    		
		    		}
	    		}//약수 개수 cnt
	    		
	    	} //0이 아닐때만 if문
	    } //수열 전체 확인
	    
	    if (ans ==1) {
	    	ans = -1;
	    }

		System.out.println(ans);

	} //main

} //class
