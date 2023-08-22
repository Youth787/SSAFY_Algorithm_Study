//그냥 푼 버전

import java.util.Arrays;
import java.util.Scanner;

//[문제] 자연수 n개(2 or 3)가 주어지면 공약수를 모두 구하기
//[입력] 첫 줄 n. 둘째 줄 공약수를 구해야 하는 자연수 n개 
//[출력] 공약수를 오름차순으로 한줄씩 출력

public class p5618 {

	public static void main(String[] args) {

		Scanner sc =new Scanner (System.in);
		
		int n = sc.nextInt(); //몇개의 수가 주어지는가
		
		//제일 작은 수를 기준으로 최대공약수를 찾음
		//최대공약수를 구하기 ->그 약수 구하기
		if ( n == 2 ) {
      
      //배열로 n개의 수를 받고 Arrays.sort 사용하여 오름차순 정렬
			int [] arr = new int [2];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			Arrays.sort(arr);
      
			int lcm = 1; //최대공약수 저장할 변수
      
			for (int i = 1; i<=arr[0]; i++) {
        //i= 1부터 제일 작은 수에 나눠보면서
        //i로 나눴을 때 n개의 수들이 다 나머지가 0이 뜨는지를 확인함
        //최대공약수는 (n개의 수가 다 i로 나누어떨어지는 경우) i로 나눴을 때의 몫
				lcm = arr[0]/i;
				if (arr[0]%i == 0 && arr[1]%lcm ==0) {
					break;
				}
			}

      //출력은 최대공약수를 i = 1부터 자기자신까지 나누면서 나머지 0일때 i 출력
			for (int i = 1; i <= lcm; i++) {
				if (lcm%i == 0) {
					System.out.println(i);
				}
			}
		} else if ( n == 3 ) {
      
      //배열로 n개의 수를 받고 Arrays.sort 사용하여 오름차순 정렬
			int [] arr = new int [3];
			for (int i = 0; i<3; i++) {
				arr[i] =sc.nextInt();
			}
			Arrays.sort(arr);
      
			int lcm = 1; //최대공약수 저장할 변수
      
			for (int i = 1; i<=arr[0]; i++) {
				lcm = arr[0]/i;
				if (arr[0]%i == 0 && arr[1]%lcm ==0 && arr[2]%lcm == 0) {
					break;
				}
			}
			for (int i = 1; i <= lcm; i++) {
				if (lcm%i == 0) {
					System.out.println(i);
				}
			}
			
			
		} //n이 2일때와3일떄 구분

	} //main

} //class
