package p10870_피보나치수5;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fibo(sc.nextInt()));
	}//main
	
	public static int fibo(int a) {
		if (a == 0) return 0;
		if (a == 1) return 1;
		
		return fibo(a-1) + fibo(a-2);
	}
}//class


/*
import java.util.Scanner;

public class Main {
	public static int [] dp; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int [n+1];
		System.out.println(fibo(n));
	}//main
	
	public static int fibo(int a) {
		//dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2 ; i <= a; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[a];
	}
}//class

*/
