
//재귀x.오답
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//[문제] 0 1 ... n번째 피보나치 수 출력
//[입력] n(20보다 작거나 같은 자연수 또는 0)
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int fst = 0;//첫번째 피보나치 수
		int scd = 1;//두번째 피보나치 수
		
        if (n>2){
    		while (n-1>0) {
	    		int temp = fst + scd; //앞의 두 수 더해서 임시 저장
		    	//fst를 scd로 덮고, 새로운 수를 scd에 이동
			    fst = scd;
			    scd = temp;
			    n--;
		    } //while
        } else scd = n;
		System.out.println(scd);
	}//main

}//class

