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
