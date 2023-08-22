package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1934_최소공배수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //입력받을 bf
		int tc = Integer.parseInt(bf.readLine()); //테케 개수 
		StringTokenizer st; 
		
		for (int t=1; t<=tc; t++) {
			
		String tmp = bf.readLine(); //숫자들을 일단 읽어옴 
		st = new StringTokenizer(tmp," "); //둘로 쪼개서 하나씩 담음 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		System.out.println(lcm(a,b));
		
		}
		
	}
	
	//최대공약수(GCD, Greatest Common Divisor)
	//유클리드 호제법
	public static int gcd(int n, int m) { 
		
		if (n%m==0) { //나머지(remainder)가 0이 될 때 
			return m; //제수(나누는 수. divisor)를 반환하고 종료 
		}
		
		return gcd(m,n%m); //나머지가 0이 될 때까지 재귀함수를 실행 
		
	}	
	
	//최소공배수(LCM, Least Common Multiple) 
	public static int lcm(int n, int m) {

		return n*m/gcd(n,m); //두 수의 최소공배수 = 두 수의 곱을 최대공약수로 나누면 된다 
		
	}

	
}
